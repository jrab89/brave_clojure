(ns brave-clojure.ch4-test
  (:require [clojure.test :refer :all]
            [brave-clojure.ch4 :refer :all]))

(def edward   {:name "Edward Cullen"   :glitter-index 10})
(def jacob    {:name "Jacob Black"     :glitter-index 3})
(def carlisle {:name "Carlisle Cullen" :glitter-index 6})
(def bella    {:name "Bella Swan"      :glitter-index 0})
(def charlie  {:name "Charlie Swan"    :glitter-index 0})

(def suspects [edward jacob carlisle bella charlie])

(deftest test-names
  (is (= [(:name edward)
          (:name jacob)
          (:name carlisle)
          (:name bella)
          (:name charlie)]
         (names suspects))))

(deftest test-append
  (is (= suspects
         (append [edward jacob carlisle bella] charlie))))

(deftest test-validate
  (are [validations suspect valid] (= valid (validate validations suspect))
    {:name string? :key-missing even?} bella false
    {:name string? :glitter-index integer?} edward true
    {:name string? :glitter-index integer?} jacob true))


(deftest test-back-to-csv
  (let [expected-csv
        (str "Edward Cullen,10\n"
             "Jacob Black,3\n"
             "Carlisle Cullen,6\n"
             "Bella Swan,0\n"
             "Charlie Swan,0")]
    (is (= expected-csv
           (back-to-csv suspects)))))
