(ns bowling-game-clj.core-spec
    (:require [bowling-game-clj.core :refer :all]
     [speclj.core :refer :all]))

(describe "A bowling game"
          (describe "score"
                    (it "Gutter game results in a score of zero"
                        (should= 0 (score (repeat 0))))
                    (it "One pins game results in a score of twenty"
                        (should= 20 (score (repeat 1))))
                    (it "Spare adds next roll to score"
                        (should= 16 (score [5 5 3])))
                    (it "Strike adds next two rolls to score"
                        (should= 28 (score [10 5 4])))
                    (it "Perfect game results in a score of three-hundred"
                        (should= 300 (score (repeat 10)))))

          (describe "-> frames"
                    (it "No rolls results in no frames"
                        (should= [] (->frames [])))
                    (it "One roll results in one frame"
                        (should= [[1]] (->frames [1])))
                    (it "Two rolls results in one frame"
                        (should= [[1 2]] (->frames [1 2])))
                    (it "Three rolls results in one frame"
                        (should= [[1 2] [3]] (->frames [1 2 3])))
                    (it "Spare adds next row to frame"
                        (should= [[5 5 4] [4]] (->frames [5 5 4])))
                    (it "Strike adds next two row to frame"
                        (should= [[10 5 4] [5 4]] (->frames [10 5 4])))))




