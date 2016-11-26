(ns komiform.core
  (:gen-class)
  (:require [org.httpkit.client]
            [clojure.java.io]))

(def ^:private server-default (str "http://komiform.top/form"))
(def ^:private cache-location (str (System/getProperty "user.home")
                                   "/.komiform/cache/"))
(defn init! []
  (assert (= (last cache-location) \/) "Cache location string must end in /")
  (let [cache (clojure.java.io/as-file cache-location)]
    (if (not (.exists cache))
      (.mkdirs cache))))

(defn cache-hit? [hash]
  (.exists (clojure.java.io/file (str cache-location hash))))

(defn get-from-cache [hash]
  (slurp (str cache-location hash)))

(defn cache-persist! [hash body]
  (spit (str cache-location hash) body))

(defn publish!
  ([form] (publish! server-default form))
  ([server-uri form] (future (:body @(org.httpkit.client/post server-uri
                                                              {:body (str form)})))))

(defn get-form
  "LISP <3"
  ([hash] (get-form server-default hash))
  ([server-uri hash]
   {:post [(future? %)]}
   (future
     (eval
      (read-string
       (if (cache-hit? hash)
         (get-from-cache hash)
         (let [body (:body @(org.httpkit.client/get
                             (str server-uri "/" hash)))]
           (cache-persist! hash body)
           body)))))))

(init!)
