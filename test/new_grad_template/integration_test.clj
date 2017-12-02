(ns new-grad-template.handler-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [new-grad-template.handler :refer :all]
            [new-grad-template.numbers :refer :all]))

(fact "can query empty list of numbers"
      (reset-numbers)
      ((app (mock/request :get "/numbers/7")) :body) => "0")

(fact "can add and query numbers"
      (reset-numbers)
      ((app (mock/request :post "/numbers?N=1"))  :status) => 201
      ((app (mock/request :post "/numbers?N=3"))  :status) => 201
      ((app (mock/request :post "/numbers?N=5"))  :status) => 201
      ((app (mock/request :get  "/numbers/4"))    :body)   => "1"
      ((app (mock/request :post "/numbers?N=7"))  :status) => 201
      ((app (mock/request :post "/numbers?N=9"))  :status) => 201
      ((app (mock/request :post "/numbers?N=11")) :status) => 201
      ((app (mock/request :get  "/numbers/7"))    :body)   => "2")