(ns learning-compojure.controller.flickrmap
  (:use
    [clojure.tools.logging  :only [info error]]
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

  ;{ "photos": { 
  ;    "page": 1, 
  ;    "pages": "1501", 
  ;    "perpage": "500", 
  ;    "total": "750130",
  ;    "photo": [
  ;      { "id": "11595181043", "owner": "29204155@N08", 
  ;        "secret": "b3d61993d3", "server": "3700", 
  ;        "farm": 4, "title": "My 2013 Last Supper at Blue Ocean", 
  ;        "ispublic": 1, "isfriend": 0, "isfamily": 0, 
  ;        "latitude": -8.698568, "longitude": "115.162478", "accuracy": 16, 
  ;        "context": 0, "place_id": "87t4ILNUVLqo7QaKNw", 
  ;        "woeid": "56013199", "geo_is_family": 0, 
  ;        "geo_is_friend": 0, "geo_is_contact": 0, "geo_is_public": 1 
  ;      }
  ;    ]
  ;  }
  ;}

  (defn flickrmap []
    (info "learning-compojure.controller.flickrmap/flickrmap")
    (json-response {:foo "flickrmap"}))




