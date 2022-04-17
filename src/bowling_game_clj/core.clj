(ns bowling-game-clj.core)

(defn ten? [n] (= 10 n))

(defn- sum [rolls] (reduce + rolls))

(defn- spare? [rolls]
       (ten? (sum (take 2 rolls))))

(defn- strike? [rolls]
       (ten? (sum (take 1 rolls))))

(defn rolls-for-frame [rolls]
      (if (or (strike? rolls) (spare? rolls))
       (take 3 rolls)
       (take 2 rolls)))

(defn rest-rolls [rolls] (if (strike? rolls)
                          (drop 1 rolls)
                          (drop 2 rolls)))

(defn ->frames [rolls]
      (if (empty? rolls)
       []
       (cons (rolls-for-frame rolls)
             (lazy-seq (->frames (rest-rolls rolls))))))

(defn score [rolls]
      (sum (flatten (take 10 (->frames rolls)))))
