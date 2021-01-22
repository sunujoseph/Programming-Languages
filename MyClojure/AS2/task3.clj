(require '[clojure.string :as str])
(use '[clojure.string :only (join split)])

(def ts "yo class 2033;232233;Kke 2017;Lecture;John Smith;sdsddsd;jan 2006;Lecture;Mary Jane")
(def s (slurp "2017-10-15.txt"))


(println "-----------------------------------------------")

(def temps (str/split ts #";"))


(def tempsnum (count temps))

(def fq 0)

(loop [x 0]
  (when (< x tempsnum)
    (if (.contains (get temps x) "Lecture")
       (print (get temps x) " " (get temps (- x 1)) "\n") "")

        (recur (+ x 1))))
;;USE conj to add a value into a temporay vector
;;Find intructor name and match them with a the room number using a array
;; make a temp array hold the names with their corrsponding the class number to have hold these values
;;Then use another loop to match the the room numbers to match the instructors
;;again the problem is adding values to another vector without the values disappearing
