(ns learning-compojure.handler
  (:use     [clojure.tools.logging  :only [info error]]
            [compojure.core                           ]
            [learning-compojure.controller.flickrmap  ]
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

(defn lazy-fibo []
  (map first (iterate (fn [[a b]] [b (+ a b)]) [1N 1N])))

(defn get-last [n] (json-response {:fibo (last (take n (lazy-fibo)))}))

(defroutes app-routes
  (GET                "/fibo/:n"        [n]       (get-last (read-string n))  )
  (GET                "/flickrmap"      []        (flickrmap)                 )
  (GET                "/foo/:id.:ext"   [ext id]  (foo ext id)                )
  (GET                "/"               []        (main_index)                ) 
  (route/not-found    "Not Found"                                             ))

(def app
  (handler/site app-routes))
