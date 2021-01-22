;;(load-file "q1.clj") to load file
;;(println "hello")
;;(apply + (range 1E6))



;;(let [start (System/nanoTime)
;;      result (apply + (range 1E6))
;;      end (System/nanoTime)]
;;(println "Took:" (- end start) "ns")
;;result)





(defmacro benchmark [code]
 ;;code = (apply + (range 1E6)
(let [start (System/nanoTime)
    result code
      end (System/nanoTime)]
(println "Took:" (- end start) "ns")
result)
)


(benchmark (apply + (range 1E6)))
