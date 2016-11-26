(defproject komiform-server "1.0.0"
  :description "A better way to get libraries"
  :url "http://example.com/FIXME"
  :license {:name "GNU GPL v3"
            :url "https://www.gnu.org/licenses/gpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.2.0"]
                 [compojure "1.5.1"]]
  :main ^:skip-aot komiform-server.core
  :local-repo "repo"
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
