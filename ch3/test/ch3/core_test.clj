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

(deftest test-dec-maker-with-are
  (are [start dec-by expected] (= expected ((dec-maker dec-by) start))
    4 1 3
    6 3 3
    7 5 2))

(deftest test-mapset
  (is (= #{2 3} (mapset inc [1 1 2 2]))))

(deftest test-symmetrize-alien-body-parts
  (let [input-parts [{:name "head",  :size 3}
                     {:name "eye-1", :size 1}
                     {:name "ear-1", :size 1}]
        expected [{:name "head",  :size 3}
                  {:name "eye-1", :size 1}
                  {:name "eye-2", :size 1}
                  {:name "eye-3", :size 1}
                  {:name "ear-1", :size 1}
                  {:name "ear-2", :size 1}
                  {:name "ear-3", :size 1}]]
    (is (= expected (symmetrize-alien-body-parts input-parts 3)))))
