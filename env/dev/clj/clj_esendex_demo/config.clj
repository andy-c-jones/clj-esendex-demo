(ns clj-esendex-demo.config
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [clj-esendex-demo.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[clj-esendex-demo started successfully using the development profile]=-"))
   :middleware wrap-dev})
