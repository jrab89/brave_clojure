(ns brave-clojure.ch5-test
  (:require [clojure.test :refer :all]
            [brave-clojure.ch5 :refer :all]))

;; (deftest test-mapset
;;   (is (= #{2 3} (mapset inc [1 1 2 2]))))

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


;; (deftest jeffs-comp-test
;;   (are [character attr expected] (= expected (attribute attr character))
;;     smooches :intelligence 10
;;     smooches :strength 4
;;     smooches :dexterity 5)
