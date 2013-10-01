(define (prime_factors x)
  (let pf ((n x) (p 2))
    (if (< n (* p p))
      (list n)
      (if (= (modulo n p) 0)
        (cons p (pf (quotient n p) p))
        (pf n (+ p 1))
      )
    )
  )
)

(display (apply max (prime_factors 600851475143)))

(exit)