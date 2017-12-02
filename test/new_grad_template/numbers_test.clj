(ns new-grad-template.numbers-test
  (:require [midje.sweet :refer :all] 
            [new-grad-template.numbers :refer :all]))

(fact "can add numbers"
      (reset-numbers!)
      (get-numbers) => []
      (add-number! 1)
      (add-number! 2)
      (add-number! 3)
      (get-numbers) => [1 2 3]
      (add-number! 4)
      (add-number! 5)
      (get-numbers) => [1 2 3 4 5])