Algoritmo "Equa��o do 2� grau"

var
   a, b, c, delta, x1, x2 : real
inicio
//Aqui � onde se inserem as informa��es.
   escreva ("Coeficiente de x�: ")
      leia(a)
   escreva ("Coeficiente de x: ")
      leia(b)
   escreva ("Termo independente: ")
      leia(c)
//Aqui o delta � calculado.
      delta <- (b*b-(4*a*c))
   se (delta<0) entao
//Termina aqui se delta for menor que 0.
      escreva ("As ra�zes n�o s�o reais.")
   senao
//Nessa parte as ra�zes s�o calculadas
      x1 <- (-b+delta^(1/2))/2*a
      x2 <- (-b-delta^(1/2))/2*a
      escreva ("A ra�z X' �: ",x1," A raiz X'' �: ",x2)
   fimse
fimalgoritmo