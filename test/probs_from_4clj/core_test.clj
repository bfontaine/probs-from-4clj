(ns probs-from-4clj.core-test
  (:require [clojure.test :refer :all]
            [probs-from-4clj.core :refer :all]))

(deftest can-nothing-but-the-truth
  (is (= nothing-but-the-truth-solution true)))
