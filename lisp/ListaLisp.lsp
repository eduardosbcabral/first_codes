(defun ex1 (n)
	(format t "~D dias" (* n 365))
)

(defun ex2 (n)
	(setq sal (/ n 937.0))
	(setq dolar (/ n 3.12))
	(format t "Salario minimo: ~D  Dolar: ~D" sal dolar)
)

(defun ex3 (n1 n2 n3)
	(if (= (+ n2 n3) n1) (print "E igual") (print "Nao e igual"))
)

(defun ex4 (string)
	(setq fim (length string))
    (print (subseq string (- fim 1) fim))
    (setq string (subseq string 0 (- fim 1)))
	(if (> fim 1) (ex4 string))
)

(defun ex5 (n)
	(if (= (mod n 3) 0) (decf n 2))
	(if (= (mod n 3) 2) (decf n 1))
	(if (> n 1) (ex5 (- n 3)))
	(print n)
)

(defun ex6 (ini passo fim)
	(print ini)
	(if (< ini fim) (ex6 (+ passo ini) passo fim) "Fim")
)

(defun ex7 (n)
	(if (> n 1) (print (* n (ex7 (- n 1)))) 1)
)

(defun ex8 (n)
	(if (< n 3) 1 (+ (ex8 (- n 1)) (ex8 (- n 2))))
)

(defun ex9 (n1 n2)
	(if (= n1 n2) (format t "O numero ~D e igual ao ~D" n1 n2))
	(if (< n1 n2) (format t "O numero ~D e maior que o numero ~D" n2 n1))
	(if (> n1 n2) (format t "O numero ~D e maior que o numero ~D" n1 n2))
)

(defun divs (n c d)
(if (> c n) d (divs n (+ c 1) (if (= 0 (mod n c))(+ d 1)d)))
)

(defun primo (n)
(if (= (divs n 1 0)2) T NIL)
)

(defun ex10 (n1 n2)
	(if (< n1 1)(print "Terminou")(if (primo n2) (progn (print n2) (ex10 (- n1 1) (+ n2 1))) (ex10 n1 (+ n2 1))))	
)
