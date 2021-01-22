(defn area
  "Calculate the area of a shape"
  [shape]
  (condp = (:type shape)
    :triangle  (* (:base shape) (:height shape) (/ 1 2))
    :rectangle (* (:length shape) (:width shape))))

(area {:type :triangle :base 2 :height 4})
;; -> 4N

(area {:type :rectangle :length 2 :width 4})
;; -> 8
