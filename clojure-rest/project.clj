(defproject clojure-rest "0.1.0-SNAPSHOT"
  :description "Textos en Clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [cheshire "5.3.1"]
                 [org.clojure/data.xml "0.0.7"]]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler clojure-rest.core/app})
