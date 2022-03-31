Algoritmo "Equação do 2º grau"

var
   a, b, c, delta, x1, x2 : real
inicio
//Aqui é onde se inserem as informações.
   escreva ("Coeficiente de x²: ")
      leia(a)
   escreva ("Coeficiente de x: ")
      leia(b)
   escreva ("Termo independente: ")
      leia(c)
//Aqui o delta é calculado.
      delta <- (b*b-(4*a*c))
   se (delta<0) entao
//Termina aqui se delta for menor que 0.
      escreva ("As raízes não são reais.")
   senao
//Nessa parte as raízes são calculadas
      x1 <- (-b+delta^(1/2))/2*a
      x2 <- (-b-delta^(1/2))/2*a
      escreva ("A raíz X' é: ",x1," A raiz X'' é: ",x2)
   fimse
fimalgoritmo