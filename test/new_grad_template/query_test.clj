(ns new-grad-template.query-test
  (:require [midje.sweet :refer :all] 
            [new-grad-template.query :refer :all]))

(fact "(query [] ?) => 0"
      (let [result (query [] 1)]
        result => 0))

(fact "(query [1 2 3 4 5] 3) => 2"
      (let [result (query [1 2 3 4 5] 3)]
        result => 2))