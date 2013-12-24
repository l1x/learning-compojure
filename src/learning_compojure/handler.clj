(ns learning-compojure.handler
  (:use     [clojure.tools.logging  :only [info error]]
            [compojure.core                           ]
            [ring.util.json-response                  ])
  (:require [compojure.handler      :as handler       ]
            [compojure.route        :as route         ]))

(defn main_index []
  (info "main_index")
  "Hello SZOP")

(defmulti foo (fn [ext _] ext))
  (defmethod foo "json" [ext id]
    (info "ext: " ext " id: " id)
    (json-response {:foo id}))
  (defmethod foo "html" [ext id]
    (info "ext: " ext " id: " id)
    (str "<h1>" id "</h1>"))
  (defmethod foo :default [ext id]  
    (error "Unsupported extension")
    (str "Unsupported extension ext: " ext " id: " id))

(defroutes app-routes
  (GET                "/"                []        (main_index) ) 
  (GET                "/foo/:id.:ext"    [ext id]  (foo ext id) )
  (route/not-found    "Not Found"                               ))

(def app
  (handler/site app-routes))
