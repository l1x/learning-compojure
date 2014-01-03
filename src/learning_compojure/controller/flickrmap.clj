(ns learning-compojure.controller.flickrmap
  (:require 
    [clojure.data.json      :as djson         ])
  (:use
    [clojure.tools.logging  :only [info error]]
    [ring.util.response                       ]
    [ring.util.json-response                  ]))

  ; http://api.flickr.com/services/rest/?method=flickr.photos.search
  ; api_key=b8b0d30d88e22a4ff73b66d12e1c5bf4
  ; tags=people
  ; min_taken_date=2013-11-21+00%3A00%3A00
  ; max_taken_date=2013-11-21+23%3A59%3A59
  ; has_geo=1
  ; extras=geo
  ; per_page=500
  ; format=json
  ; nojsoncallback=1
  ; auth_token=72157639099303255-3e5813a0794a9d39
  ; api_sig=9d28a160a4a498f2f06cfea94c2e2306
  ;
  ; http://www.flickr.com/services/api/explore/flickr.photos.search

  (def photos-raw 
    (slurp "resources/public/sample.json"))

  (def photos-json 
    (djson/read-str photos-raw))

  (def images-arr 
    (get-in photos-json ["photos" "photo"]))

  (def image-ids 
    (map #(get-in % ["id"]) images-arr))

  (defn id-lat-lon [image]
    (let 
     [id  (get-in image ["id"]) 
      lat (get-in image ["latitude"]) 
      lon (get-in image ["longitude"])]
       {:id id :lat lat :lon lon}))

  (def images-seq (map id-lat-lon images-arr))

  (def user-ns-map (ns-map 'user))

  (defn flickrmap []
    (info "learning-compojure.controller.flickrmap/flickrmap")
    (json-response images-seq))


;    (-> (response photos)
;        (content-type "application/json")))

