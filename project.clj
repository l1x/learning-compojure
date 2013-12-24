(defproject learning-compojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [
    [org.clojure/clojure          "1.5.1"]
    [compojure                    "1.1.6"]
    [org.clojure/tools.logging    "0.2.6"]
    [ring-json-response           "0.2.0"]
    [http-kit                     "2.1.13"]
  ]
  :plugins [
    [lein-ring "0.8.8"]
  ]
  :ring {:handler learning-compojure.handler/app}
  :profiles
  {:dev 
    {:dependencies [
      [javax.servlet/servlet-api "2.5"]
      [ring-mock "0.1.5"]
    ]}
  })
