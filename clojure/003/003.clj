(defn is_prime
  ([x]
    (if (or (< x 2) (and (= (mod x 2) 0) (not= x 2)))
      false
      (if (< x 101)
        (= true (some #(= x %) '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97)))
        (if (= true (some #(= (mod x %) 0) '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97)))
          false
          (loop [guess 101 limit (Math/ceil (Math/sqrt x))]
            (if (< limit guess)
              true
              (if (= (mod x guess) 0)
                false
                (recur (+ guess 2) limit)
              )
            )
          )
        )
      )
    )
  )
)

(defn max_prime_factor
  ([x]
    (loop [guess (if (= (mod (Math/round (Math/sqrt x)) 2) 0) (+ (Math/round (Math/sqrt x)) 1) (Math/round (Math/sqrt x)))]
      (if (= guess 1)
        1
        (if (= (mod x guess) 0)
          (if (is_prime guess)
            guess
            (recur (- guess 2))
          )
          (recur (- guess 2))
        )
      )
    )
  )
)

(println (max_prime_factor 600851475143))
