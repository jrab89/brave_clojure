(ns ch3.core-test
  (:require [clojure.test :refer :all]
            [ch3.core :refer :all]))

(deftest test-add-100
  (is (= 100 (add-100 0))))

(deftest test-dec-maker
  (doseq [[dec-by start expected]
          [[1 4 3]
           [3 6 3]
           [5 7 2]]]
    (let [decrementer (dec-maker dec-by)]
      (is (= expected (decrementer start))))))
