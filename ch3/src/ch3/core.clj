(ns ch3.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn add-100 [n]
  (+ n 100))

(defn dec-maker [n]
  #(- % n))

(defn mapset [f coll]
  (set (map f coll)))
