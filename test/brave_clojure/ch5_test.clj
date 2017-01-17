(ns brave-clojure.ch5-test
  (:require [clojure.test :refer :all]
            [brave-clojure.ch5 :refer :all]))

(def smooches
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

(deftest attribute-test
  (are [attr expected] (= expected (attribute attr smooches))
    :intelligence 10
    :strength 4
    :dexterity 5))

(deftest jeffs-comp-test
  (is (= 7
         ((jeffs-comp inc *) 1 2 3)))
  (is (= "25"
         ((jeffs-comp str inc +) 8 8 8)))
  (is (= 3
         ((jeffs-comp +) 1 2))))
