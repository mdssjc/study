(defproject picture-gallery "0.1.0-SNAPSHOT"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies [[buddy "1.3.0"]
                 [compojure "1.5.2"]
                 [conman "0.6.3"]
                 [cprop "0.1.10"]
                 [funcool/struct "1.0.0"]
                 [luminus-immutant "0.2.3"]
                 [luminus-migrations "0.3.0"]
                 [luminus-nrepl "0.1.4"]
                 [luminus/ring-ttl-session "0.3.2"]
                 [luminus-log4j "0.1.5"]
                 [markdown-clj "0.9.99"]
                 [metosin/compojure-api "1.1.10"]
                 [metosin/muuntaja "0.2.1"]
                 [metosin/ring-http-response "0.8.2"]
                 [mount "0.1.11"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.521" :scope "provided"]
                 [org.clojure/tools.cli "0.3.5"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.webjars.bower/tether "1.4.0"]
                 [org.webjars/bootstrap "4.0.0-alpha.5"]
                 [org.webjars/font-awesome "4.7.0"]
                 [org.webjars/webjars-locator-jboss-vfs "0.1.0"]
                 [ring-webjars "0.1.1"]
                 [ring/ring-core "1.6.0-RC3"]
                 [ring/ring-defaults "0.2.3"]
                 [selmer "1.10.7"]
                 [bouncer "1.0.1"]
                 [reagent "0.6.1"]
                 [reagent-utils "0.2.1"]
                 [cljs-ajax "0.5.9"]
                 [secretary "1.2.3"]]
  :min-lein-version "2.0.0"
  :jvm-opts ["-server" "-Dconf=.lein-env"]
  :source-paths ["src/clj" "src/cljc"]
  :test-paths ["test/clj"]
  :resource-paths ["resources" "target/cljsbuild"]
  :target-path "target/%s/"
  :main ^:skip-aot picture-gallery.core
  :migratus {:store :database :db ~(get (System/getenv) "DATABASE_URL")}
  :plugins [[lein-cprop "1.0.1"]
            [migratus-lein "0.4.4"]
            [lein-cljsbuild "1.1.6"]
            [lein-immutant "2.1.0"]]
  :clean-targets ^{:protect false}
  [:target-path [:cljsbuild :builds :app :compiler :output-dir] [:cljsbuild :builds :app :compiler :output-to]]
  :cljsbuild
  {:builds
   {:app
    {:source-paths ["src/cljc" "src/cljs"]
     :compiler
     {:output-to "target/cljsbuild/public/js/app.js"
      :output-dir "target/cljsbuild/public/js/out"
      :externs ["react/externs/react.js"
                "resources/externs.js"]
      :pretty-print true}}}}
  :figwheel
  {:http-server-root "public"
   :nrepl-port       7002
   :css-dirs         ["resources/public/css"]
   :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :profiles
  {:uberjar       {:omit-source    true
                   :prep-tasks     ["compile" ["cljsbuild" "once" "min"]]
                   :cljsbuild
                   {:builds
                    {:min
                     {:source-paths ["src/cljc" "src/cljs" "env/prod/cljs"]
                      :compiler
                      {:output-to     "target/cljsbuild/public/js/app.js"
                       :optimizations :advanced
                       :pretty-print  false
                       :closure-warnings
                       {:externs-validation :off :non-standard-jsdoc :off}}}}}
                   :aot            :all
                   :uberjar-name   "picture-gallery.jar"
                   :source-paths   ["env/prod/clj"]
                   :resource-paths ["env/prod/resources"]}
   :dev           [:project/dev :profiles/dev]
   :test          [:project/dev :project/test :profiles/test]
   :project/dev   {:dependencies   [[prone "1.1.4"]
                                    [ring/ring-mock "0.3.0"]
                                    [ring/ring-devel "1.5.1"]
                                    [pjstadig/humane-test-output "0.8.1"]
                                    [binaryage/devtools "0.9.4"]
                                    [com.cemerick/piggieback "0.2.1"]
                                    [doo "0.1.7"]
                                    [figwheel-sidecar "0.5.10"]]
                   :plugins        [[com.jakemccrary/lein-test-refresh "0.20.0"]
                                    [lein-doo "0.1.7"]
                                    [lein-figwheel "0.5.10"]
                                    [org.clojure/clojurescript "1.9.521"]]
                   :cljsbuild
                   {:builds
                    {:app
                     {:source-paths ["src/cljs" "src/cljc" "env/dev/cljs"]
                      :compiler
                      {:main          "picture-gallery.app"
                       :asset-path    "/js/out"
                       :output-to     "target/cljsbuild/public/js/app.js"
                       :output-dir    "target/cljsbuild/public/js/out"
                       :source-map    true
                       :optimizations :none
                       :pretty-print  true}}}}
                   :doo            {:build "test"}
                   :source-paths   ["env/dev/clj"]
                   :resource-paths ["env/dev/resources"]
                   :repl-options   {:init-ns user}
                   :injections     [(require 'pjstadig.humane-test-output)
                                    (pjstadig.humane-test-output/activate!)]}
   :project/test  {:resource-paths ["env/test/resources"]
                   :cljsbuild
                   {:builds
                    {:test
                     {:source-paths ["src/cljc" "src/cljs" "test/cljs"]
                      :compiler
                      {:output-to     "target/test.js"
                       :main          "picture-gallery.doo-runner"
                       :optimizations :whitespace
                       :pretty-print  true}}}}}
   :profiles/dev  {}
   :profiles/test {}})
