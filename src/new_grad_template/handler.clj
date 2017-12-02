(ns new-grad-template.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [new-grad-template.numbers :refer :all]
            [new-grad-template.query :refer :all]))

(defroutes app-routes
  (GET  "/numbers/:n{[0-9]+}" [n] (str (query (get-numbers) (read-string n))))
  (GET  "/numbers" [] (str (get-numbers)))
  (POST "/numbers" [N] (str (add-number! (read-string N))) {:status 201})
  (route/not-found "Not Found"))
  

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
