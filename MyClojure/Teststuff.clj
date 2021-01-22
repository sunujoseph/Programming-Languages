;; lein repl
(comment
(println "Hello world")
(defn greet  [name]  (str "Hello, " name))
(defn square [x] (* x x))
;;(defn testp [nam num] (println "Hi " nam (+ num 1)))
;;====================================================================================
;; Load a file
;;Step 1: lein repl
;;Step 2: (load-file "your_file.clj") include the "" with your file name
;;=====================================================================================
(defn testp [nam num] (println "Hi " nam ". Square of " num " is "(* num num) "."))
;;(println "GREET")
;;(greet "Students");;not print
;;(println "SQUARE")
;(square 3);; not print
;(println (square 3));; will print
;(println "TEST")
(testp "Jo" (* (/ 3 3) 3 ) )


;;(.contains "hello world" "he")
;;=> true

(.indexOf "ababc" "ab")
;;=> 0
(.indexOf "ababc" "ab" 1)
;;=> 2
);;comment ends

(require '[clojure.string :as str])
(str/split "Clojure is awesome!" #" ")
