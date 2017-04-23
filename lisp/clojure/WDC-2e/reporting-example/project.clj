(defproject reporting-example "0.1.0-SNAPSHOT"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [selmer "1.10.7"]
                 [markdown-clj "0.9.99"]
                 [luminus/config "0.8"]
                 [ring-middleware-format "0.7.2"]
                 [metosin/ring-http-response "0.8.2"]
                 [bouncer "1.0.1"]
                 [org.webjars/bootstrap "4.0.0-alpha.2"]
                 [org.webjars/font-awesome "4.5.0"]
                 [org.webjars.bower/tether "1.1.1"]
                 [org.webjars/jquery "2.2.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [com.taoensso/tower "3.0.2"]
                 [compojure "1.5.2"]
                 [ring-webjars "0.1.1"]
                 [ring/ring-defaults "0.2.3"]
                 [ring "1.5.1" :exclusions [ring/ring-jetty-adapter]]
                 [mount "0.1.11"]
                 [luminus-nrepl "0.1.4"]
                 [migratus "0.9.0"]
                 [conman "0.6.3"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [org.webjars/webjars-locator-jboss-vfs "0.1.0"]
                 [luminus-immutant "0.2.3"]
                 [luminus-log4j "0.1.5"]
                 [clj-pdf "2.2.21"]]

  :min-lein-version "2.0.0"
  :uberjar-name "reporting-example.jar"
  :jvm-opts ["-server"]
  :source-paths ["src/clj"]
  :resource-paths ["resources"]

  :main reporting-example.core
  :migratus {:store :database}

  :plugins [[lein-environ "1.1.0"]
            [migratus-lein "0.4.4"]]
  :target-path "target/%s/"
  :profiles
  {:uberjar     {:omit-source    true
                 :env            {:production true}
                 :aot            :all
                 :source-paths   ["env/prod/clj"]
                 :resource-paths ["env/prod/resources"]}
   :dev         [:project/dev :profiles/dev]
   :test        [:project/test :profiles/test]
   :project/dev {:dependencies [[prone "1.1.4"]
                                [ring/ring-mock "0.3.0"]
                                [ring/ring-devel "1.5.1"]
                                [pjstadig/humane-test-output "0.8.1"]
                                [mvxcvi/puget "1.0.1"]]


                 :source-paths   ["env/dev/clj" "test/clj"]
                 :resource-paths ["env/dev/resources"]
                 :repl-options   {:init-ns user}
                 :injections     [(require 'pjstadig.humane-test-output)
                                  (pjstadig.humane-test-output/activate!)]
                 ;;when :nrepl-port is set the application starts the nREPL server on load
                 :env            {:dev        true
                                  :port       3000
                                  :nrepl-port 7000}}
   :project/test  {:env {:test       true
                         :port       3001
                         :nrepl-port 7001}}
   :profiles/dev  {}
   :profiles/test {}})
