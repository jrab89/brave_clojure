(ns brave-clojure.ch5
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; 1. You used (comp :intelligence :attributes) to create a function that returns a character’s intelligence. Create a new function, attr, that you can call like (attr :intelligence) and that does the same thing.
;; 2. Implement the comp function.
;; 3. Implement the assoc-in function. Hint: use the assoc function and define its parameters as [m [k & ks] v].
;; 4. Look up and use the update-in function.
;; 5. Implement update-in.

(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

(defn attribute [attr character]
  (attr (:attributes character)))

(defn two-comp
  [f g]
  (fn [& args]
    (f (apply g args))))

(defn my-comp [& fs]
  (reduce (fn [result f]
            (fn [& args]
              (result (apply f args))))
          identity
          fs))


