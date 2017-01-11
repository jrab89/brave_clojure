(ns brave-clojure.ch4
  (:gen-class))

(def filename "suspects.csv")
(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(defn names
  [suspect-maps]
  (map :name suspect-maps))

(defn append
  [suspects new-suspect]
  (conj suspects new-suspect))

(defn validate
  [validations suspect]
  (every? (fn [[key predicate]]
            (and (key suspect)
                 (predicate (key suspect))))
          validations))

(defn back-to-csv
  [suspects]
  (clojure.string/join "\n"
                       (map (fn [suspect]
                              (->>
                               (map suspect vamp-keys)
                               (clojure.string/join ",")))
                            suspects)))
