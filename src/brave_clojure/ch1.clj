(ns brave-clojure.ch1
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def default-things ["How are you?"
                     "asdf"
                     "xyz"])

(defn say-a-thing [to-who
                   & {:keys [index things]
                      :or {index 0 things default-things}}]
  (str "Hello, "
       to-who
       "! "
       (get things index)))
