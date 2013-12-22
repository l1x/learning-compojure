(ns learning-compojure.handler
  (:use [clojure.tools.logging :only (info error)])
  (:use [compojure.core])
  (:use [ring.util.json-response])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes

  (GET "/" [] "Hello World")

  (GET "/user/:id" [id]
    (str "<h1>Hello user " id "</h1>"))

  (GET "/foo.json" []
    (json-response {:foo "bar"}))

  (route/resources "/")

  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

;(info "dividing" x "by" y)
