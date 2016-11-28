(defproject komiform "1.0.0-SNAPSHOT"
  :description "A Better way to do Dependencies"
  ;;:url "http://example.com/FIXME"
  :license {:name "GNU GPL v3"
            :url "https://www.gnu.org/licenses/gpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.2.0"]]
  :main ^:skip-aot komiform.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
