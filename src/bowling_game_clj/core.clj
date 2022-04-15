(ns bowling-game-clj.core)

(defn- sum [rolls] (reduce + rolls))

(defn- spare? [rolls]
       (= 10 (sum (take 2 rolls))))

(defn ->frames [rolls]
      (if (empty? rolls)
       []
       (cons (if (spare? rolls)
              (take 3 rolls)
              (take 2 rolls))
             (->frames (drop 2 rolls)))))

(defn score [rolls]
      (sum (take 20 rolls)))
