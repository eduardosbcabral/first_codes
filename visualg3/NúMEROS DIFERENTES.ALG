Algoritmo "Números diferentes"
var
   n1, n2, n3 : real
inicio
   escreval ("Digite o primeiro valor: ")
      leia(n1)
   escreval ("Digite o segundo valor: ")
      leia(n2)
   escreval ("Digite o terceiro valor: ")
      leia(n3)
   se (n1>n2) e (n1>n3) e (n2<n3) entao
      escreval ("O maior valor é: ",n1," e o menor valor é",n2)
   senao
   se (n1>n2) e (n1>n3) e (n2>n3) entao
      escreval ("O maior valor é: ",n1," e o menor valor é",n3)
   senao
   se (n1<n2) e (n1<n3) e (n2>n3) entao
      escreval ("O maior valor é: ",n2," e o menor valor é",n1)
   senao
   se (n1<n2) e (n1>n3) e (n2>n3) entao
      escreval ("O maior valor é: ",n2," e o menor valor é",n3)
   senao
   se (n1<n2) e (n1<n3) e (n2<n3) entao
      escreval ("O maior valor é: ",n3," e o menor valor é",n1)
   senao
   se (n1>n2) e (n1<n3) e (n2<n3) entao
      escreval ("O maior valor é: ",n3," e o menor valor é",n2)
   fimse
   fimse
   fimse
   fimse
   fimse
   fimse
   fimalgoritmo