(ns komiform.core
  (:gen-class)
  (:require [org.httpkit.client]
            [clojure.core.cache]))

(def ^:private server-default (str "http://localhost:" 3000 "/form"))
(defn publish!
  ([form] (publish! server-default form))
  ([server-uri form] (future (:body @(org.httpkit.client/post server-uri
                                                              {:body (str form)})))))
(defn get-form
  "LISP <3"
  ([hash] (get-form server-default hash))
  ([server-uri hash]
   (future (eval (read-string
                  (:body @(org.httpkit.client/get
                           (str server-uri "/" hash))))))))
