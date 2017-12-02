(ns new-grad-template.numbers)

(def numbers (atom []))

(defn reset-numbers []
  (reset! numbers []))

(defn add-number [n]
  (swap! numbers conj n))

(defn get-numbers []
  @numbers)