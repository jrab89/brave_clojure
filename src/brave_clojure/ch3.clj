(ns brave-clojure.ch3
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

(defn nth-part
  "Returns the same part, with the part name's number as n"
  [part n]
  {:name (clojure.string/replace-first (:name part) #"-\d+$" (str "-" n))
   :size (:size part)})

(defn n-matching-parts
  [part n]
  (map #(nth-part part %) (range 1 (inc n))))

(defn symmetrize-alien-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts n]
  (vec (reduce (fn [final-body-parts part]
            (concat final-body-parts (distinct (n-matching-parts part n))))
          []
          asym-body-parts)))
