(ns new-grad-template.query)

(defn query [numbers, q] (count (filter #(> % q) numbers)))
