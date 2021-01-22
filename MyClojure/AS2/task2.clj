(require '[clojure.string :as str])
(use '[clojure.string :only (join split)])

(def ts "yo class 2033;232233;Kke 2017;Lecture;John Smith;sdsddsd;jan 2006;Lecture;Mary Jane;dsdsd;Lecture;John Smith;Lecture;John Smith")
(def s (slurp "2017-10-15.txt"))


(println "-----------------------------------------------")

(def temps (str/split s #";"))


(def tempsnum (count temps))

(def fq 0)



(def temps2 [])


(loop [x 0]
    (when (< x tempsnum)
        (if (.contains (get temps x) "Lecture");;check for Lecture word
        (conj temps2 (get temps (+ x 1)));;add the Name of the intructor in another vector, this code doesnt work as should
                                      "")

          (recur (+ x 1))))

;;(sort-by val (frequencies (temps2)))
;;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
;;use the above to get the frequencies
;;USE conj to add a value into a temporay vector
;;that holds all the intructor's Names.
;;Then use the frequencies function above to get
;;the frequency of the vector list
;;conj doesn't add it properly cause after the Loop
;; it doesn't hold the values anymore
;;I tried concat and assoc, and many more but none of it works
;;I know how to do it logically but the syntax doesnt work
