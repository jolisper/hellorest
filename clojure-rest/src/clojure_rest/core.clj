(ns clojure-rest.core
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE]])
  (:require [compojure.handler :as handler]))

;GET  /textos
;GET  /textos/:id
;PUT  /textos/:id texto=abc
;POST /textos texto=abc
;DELETE /textos/:id

(defn lista-textos []
  "")

(defroutes routes
  (GET "/" request (str request))
  (GET "/textos" [] (lista-textos))
  (GET "/textos/:id" [id] "")
  (PUT "/textos/:id" [id] "")
  (POST "/textos" [] "")
  (DELETE "/textos/:id" [] ""))

(defn simple-logging-middleware [app]
  (fn [req]
    (println req)
    (app req)))

(def app
  (-> routes
      ;simple-logging-middleware
      ;handler/api
      ))

