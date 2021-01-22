(println "Hello") ;; print hello

(def richard {:last-name "Feynman"
              :first-name "Richard"
              :job "Physicist"
              :work {:school "Caltech"
                     :position "Professor"
                     :address {:city "Pasadena"
                               :state "California"
                               :country "USA"}}
              :hobbies [:science :music :art]})

(dissoc richard :job :hobbies)
