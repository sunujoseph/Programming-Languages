;; how to load file reminder
;;(load-file "your_file.clj") include the "" with your file name
;;(load-file "Test_SunuJoseph_100555297.clj")
;;QUESTION1
;;(comment ;;comment starts
(def table [
{:product "Pencil"
  :city "Toronto"
  :year "2010"
  :sales 2653.00}
{:product "Pencil"
  :city "Oshawa"
  :year "2010"
  :sales 525.00}
{:product "Bread"
  :city "Toronto"
  :year "2010"
  :sales 136264.00}
{:product "Bread"
  :city "Oshawa"
  :year nil
  :sales 242164.00}
{:product "Bread"
  :city "Ottawa"
  :year "2011"
  :sales 426164.00}])
;;);;comment ends

;;(mapv (juxt :city :year) table)


;;(doall (map #(println %) table))
;;QUESTION2--------------------------------------------------

;;(def testin1 (update-in table [0] dissoc :year :sales))

;;(def num1)
;;(update-in table [0] dissoc :year :sales)
;;(update-in table [1] dissoc :year :sales)
;;(update-in table [2] dissoc :year :sales)
(println "--------------------------------------------------------------------")


;;(def d {:foo 123 :bar { :baz 456 :bam {:whiz 789}}})
;;(use 'clojure.walk)
;;(postwalk #(if (map? %) (dissoc % :foo :bam) %) d)


;;(def themap {:a "a" :b "b" :c "c"})
;;(def i 0)
;;THIS WORKKSS AHAHAHAHAHAHAHAHHAHAAHAHAH
;;(def mymap [{:a "a" :b "b" :c "c" :d "d"} {:a "q" :b "w" :c "t" :d "u"}])
;;(use 'clojure.walk)
;;(postwalk #(if (map? %) (dissoc % :b :c :d) %) mymap)
;;(def newm (postwalk #(if (map? %) (dissoc % :b :c :d) %) mymap))
;;(print newm)

;;(reduce #(assoc %1 %2 (str "X-" (%1 %2))) mymap [:a :b])
;;(into mymap (for [k [:a :b]] [k (str "X-" (mymap k))]))
;;(apply dissoc themap [:a :b])
;;(println mymap)
(use 'clojure.walk)
(def tempq2 (postwalk #(if (map? %) (dissoc % :year :sales) %) table))
;;(print tempq2)


;;(map (fn [[k v]]
  ;;     (into {} [[:product k]
    ;;             [:city (apply str (interpose ", " (distinct (map :city v))))]]))
     ;;(group-by :product tempq2))

(def product->cities  (map (fn [[k v]]
       (into {} [[:product k]
                 [:city (apply str (interpose ", " (distinct (map :city v))))]]))
     (group-by :product tempq2)))

;;(print product->cities)


;;(def product->cities [
;;{:product "Pencil"
;;  :city {:city1 "Toronto"
;;         :city2 "Oshawa"}}
;;{:product "Bread"
  ;;:city {:city1 "Toronto"
    ;;     :city2 "Oshawa"
      ;;   :city3 "Ottawa"}}])

;;(doall (map #(println %) product->cities))
;;(run! println tablehash)
;;(clojure.pprint/write product->cities :stream nil)
;;(map println product->cities)
;;(def test1 {:a "foo", :b "bar"})
;;(vals test1)
;;(vals product->cities)
;;-----------------------------------------------------------------------------

;;QUESTION3

(use 'clojure.walk)
(def tempq3 (postwalk #(if (map? %) (dissoc % :year) %) table))


;;(def m [{:a "a" :b "b" :c "c" :d 1} {:a "a" :b "b2" :c "c2" :d 2}{:a "a" :b "b3" :c "c3" :d 3}])
(def my  {:a "a" :b "b" :c "c"})
(def m [{:a "a", :b "b","c", :c 1,3} {:a "a2", :b "b2","c2", :c 2,4}])


(def lol (map (fn [[k v]]
       (into {} [[:a k]
                 [:b (apply str (interpose ", " (distinct (map :b v))))] ])
       (into {} [[:a k]
                 [:c (apply str (interpose ", " (distinct (map :c v))))]])
       (into {} [[:a k]
                 [:d (apply str (interpose ", " (distinct (map :d v))))]])
                 )
            (group-by :a m))
             )


             (def lolp (map (fn [[k v]]
                    (into {} [[:a k]
                              [:b (apply str (interpose ", " (distinct (map :b v))))]
                              [:c (apply str (interpose ", " (distinct (map :c v))))]
                              [:d (apply str (interpose ", " (distinct (map :d v))))]
                              ])
                              )
                         (group-by :a m))
                          )

;;(def qqq (update-in {:a {:b {:x 3} :c 1}} [:a :b] dissoc :x))
;;(def qqq (assoc-in m [1 :password] "nhoJ"))
;;(def users [{:name "James" :age 26}  {:name "John" :age 43}])
;;(def qqq (update-in users [1 :age] inc))
;;(def qqq (remove #{:a "h"} #{:a "h" :b :c :d} ))
;;(def qqq (remove #{:a "a"} m ))

;;(println qqq)
;;(println m)
;;(println lol)
;;(println lolp)



(def product->bestcity (map (fn [[k v]]
       (into {} [[:product k]
                 [:city (apply str (interpose ", " (distinct (map :city v))))]
                 [:sales (apply str (interpose ", " (distinct (map :sales v))))]
                 ])
                 )
            (group-by :product tempq3))
             )

;;(def product->bestcity ...)




;;(println tempq3)
(println (sort-by val (:sales tempq3)))

;;(def sorttemp3 (sort-by val (sales tempq3)))
;;(println sorttemp3)
;;(def qqq (update-in tempq31 [] dissoc :c 1))
;;(println tempq31)


(use 'clojure.walk)
(defn postwalk-mapentry
    [smap nmap form]
(postwalk (fn [x] (if (= smap x) nmap x)) form))

;;(postwalk-mapentry [:a "a"] [:a "T"] m)


;;(println (postwalk-mapentry [:a "a"] [:a "T"] m))
;;(println obj)
;;(println (remove #{:a "a"} themap))
;;(println (remove "a" themap))


;;(def testm1 (map (fn [[k v]]
  ;;     (into {} [[:product k]
    ;;             [:city (apply str (interpose ", " (distinct (map :city v))))]]))
     ;;(group-by :product tempq3)))

;;(println tempq3)
;;(println testm1)
;;(apply max-key :sales tempq3)
;;(apply max-key :age [{:age 12} {:age 20} {:age 30}]) ;; -> {:age 30}
;;(println tempq3)
;;(def product->bestcity [
;;{:product "Pencil"
;;  :city {:city1 "Toronto"}}
;;{:product "Bread"
;;  :city {:city3 "Ottawa"}}])




;;QUESTION4

;;find max
(def tempq4 (postwalk #(if (map? %) (dissoc % :product :city :sales) %) table))


(def freqyear (frequencies tempq4))
(def mostfreqyr (key (apply max-key val freqyear)))
(def numfreq (get mostfreqyr :year))

(def table-without-missing-year (map (fn [m]
       (into {}
         (map (fn [[k v]]
              [k (if (nil? v) numfreq v)]) m)))table))


;;(println product->bestcity)
;;(println numfreq)
;;(println mostfreqyr)
;;(println freqyear)
;;(println tempq4)

;;(println (sort-by val (frequencies tempq4)))
;;(println freqyear)

;;(defn mostfrq [n items]
  ;;(->> items
    ;;frequencies
    ;;(sort-by val)
    ;;reverse
    ;;(take n)
    ;;(map first)))

;; PART 2 ----------------------------------------------------

;;(defn estimate-pi [N] ...)
(def rndN (rand-int 100))
(defn square [x] (* x x))
(defn rdis [x y] (Math/sqrt (+ (square x) (square y) )))
(defn point ([] (point (rand) (rand))) ([x y] (vector x y)))
(defn checkcircle [i] (<= (rdis i) 1))
(defn npt [] (lazy-seq (cons (point) (npt))))

(defn abs [x]
  (if (>= x 0)
    x
    (* x -1)))

(defn estimate-pi [N]
  (loop [est 0.0 err 4.0 mul 1 denom 1]
    (if (< err 0.00001)
      est
      (let [new-est (+ est (/ (* 4.0 mul) denom))]
        (recur new-est (abs (- new-est est)) (* -1 mul) (+ 2 denom))
        ))))

(println "Pi accurate to five places:" (estimate-pi 0.00001))

;;(println point)
;;(println rndN)

;;(defn estimate-pi [N])
