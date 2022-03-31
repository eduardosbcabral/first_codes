Algoritmo "Soma"

var
	n1, n2, nf, nff : real

inicio
	escreval ("Digite o primeiro valor: ")
	    leia (n1)
	escreval ("Digite o segundo valor: ")
	    leia (n2)
	nf <- n1+n2
	   se (nf>=10) entao
	nff <- nf+5
	escreval ("O valor é: ",nff)
	   senao
      se (nf<10) entao
	nff <- nf-7
	escreval ("O valor é: ",nff)
	fimse
	fimse
fimalgoritmo