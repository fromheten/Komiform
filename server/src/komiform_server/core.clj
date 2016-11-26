(ns komiform-server.core
  (:gen-class)
  (:require [org.httpkit.server]
            [compojure.core :refer [defroutes GET POST]]
            [compojure.route]
            [clojure.java.io])
  (:import [java.security MessageDigest]))

(def persistent-storage-location "/tmp/komiform/")
(def port 3000)

(defn sha256-base64
  ([input] (sha256-base64 input "SHA-256"))
  ([input hash-algo]
   {:pre (string? input)
    :post (string? %)}
   (let [hash (MessageDigest/getInstance hash-algo)]
     (. hash update (.getBytes input))
     (let [digest (.digest hash)]
       (String. (.encode (java.util.Base64/getEncoder) digest))))))

(defn persist-form!
  [form]
  {:pre [(string? form)]
   :post [(string? %)]}
  ;; create the sha256 and base64 it
  ;; write a file with that for name and `form' for content
  ;; return base64-hash
  (let [base64hash (sha256-base64 form)
        file-path (str persistent-storage-location base64hash)]
    (when (not (.exists (clojure.java.io/as-file file-path)))
      (spit file-path form))
    base64hash))

(defn get-form! [form-id]
  (slurp (str persistent-storage-location
              form-id)))

(defroutes app
  (GET "/" [] "<h1>Hello World</h1>")
  (GET "/form/:form-id" [form-id] (get-form! form-id))
  (POST "/form" request (persist-form! (slurp (:body request))))
  (compojure.route/not-found "<h1>Page not found</h1>"))

(defn -main [& args]
  (println "Hello, World!")
  (.mkdir (clojure.java.io/file persistent-storage-location))
  (org.httpkit.server/run-server app {:port port})
  (println (str "Server on port " port)))
