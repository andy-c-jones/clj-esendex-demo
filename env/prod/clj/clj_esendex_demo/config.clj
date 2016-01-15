(ns clj-esendex-demo.config
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[clj-esendex-demo started successfully]=-"))
   :middleware identity})
