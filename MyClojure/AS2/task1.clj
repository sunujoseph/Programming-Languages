;;(load-file "task.clj") to load file
;;get file
;; Create array to store entries
;; find ";" that seperates the data entries
;; Look for Key words "CSCI"
;; 
;; Loop until file is done
;; Print array







(require '[clojure.string :as str])
(use '[clojure.string :only (join split)])


(def ts "yo class 2033;232233;CSCI 1023u;sdsad;sdsdsd;sdsddsd;lol;2323;CSCI 2343u")
(def s (slurp "2017-10-15.txt"))


(println "-----------------------------------------------")
(def temps (str/split s #";"))

(def tempsnum (count temps))




(loop [x 0]
  (when (< x tempsnum)
    (if (.contains (get temps x) "CSCI")
       (print (get temps x) " " (get temps (- x 2)) "\n") "")

        (recur (+ x 1))))
