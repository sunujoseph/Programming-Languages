(require '[clojure.pprint :as pprint])

;; Q1.
;; =========================================
(def table
  [{
  :product "Pencil"
  :city    "Toronto"
  :year    2010
  :sales   2653.00
  }

  {
  :product "Pencil"
  :city "Oshawa"
  :year 2010
  :sales 525.00
  }

  {
  :product "Bread"
  :city "Toronto"
  :year 2010
  :sales 136264.00
  }

  {
  :product "Bread"
  :city "Oshawa"
  :year nil
  :sales 242634.00
  }

  {
  :product "Bread"
  :city "Ottawa"
  :year 2011
  :sales 426164.00
  }])


;; Q2. all cities for products
;; =========================================
(def product->cities
  (into {}
        (for [[prod entries] (group-by :product table)]
          [prod (map :city entries)])))

;; Q3. product and the best city
;; =========================================
(defn best-entry [entries]
  (reduce #(if (> (:sales %2) (:sales %1)) %1 %2) entries))

(def product->bestcity
  (into {}
        (for [[prod entries] (group-by :product table)]
          [prod (:city (best-entry entries))])))

;; Q4.
;; =========================================
(defn most-freq-year [table]
  (let [years (map :year table)
        freq (frequencies (map :year table))]
    (first (reverse (sort-by freq years)))))

(defn fill-nil [y entry]
  (if (nil? (get entry :year))
    (assoc entry :year y)
    entry))

(def table-without-missing-year
  (let [y (most-freq-year table)
        f (fn [entry] (fill-nil y entry))]
    (map f table)))

;; Print the results (not part of test)
;; =========================================
(println "Q2.")
(pprint/pprint product->cities)

(println "Q3.")
(pprint/pprint product->bestcity)

(println "Q4.")
(pprint/pprint table-without-missing-year)
