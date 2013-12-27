(ns learning-compojure.controller.flickrmap
  (:use
    [clojure.tools.logging  :only [info error]]
    [ring.util.json-response                  ]))

  (defn flickrmap []
    (info "learning-compojure.controller.flickrmap/flickrmap")
    (json-response {:foo "flickrmap"}))
