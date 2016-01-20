(ns clj-esendex-demo.routes.home
  (:require [clj-esendex-demo.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok see-other]]
            [clojure.java.io :as io]
            [clojure.tools.logging :as log]
            [clj-esendex.core :as client]
            [ring.util.request :as request-util]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/Send" req
    (let [params (:params req)
          dispatch (client/sms-dispatcher (:username params) (:password params))]
      (-> (client/sms-xml (:account params) (:to params) (:body params))
          dispatch
          log/info))
    (see-other "/")))
