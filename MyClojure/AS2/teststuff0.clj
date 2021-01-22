(require '[clojure.string :as str])
(use '[clojure.string :only (join split)])
;;(str/split "Clojure;is;awesome!" #";")
(println
         (join "\n"
           (split "The;Quick;Brown;Fox" #";")))
