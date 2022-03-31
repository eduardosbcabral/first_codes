Algoritmo "Idade"
var
   nasc, idade : real
inicio
      escreval ("Informe seu ano de nascimento")
   leia(nasc)
   idade <- 2016-nasc
   escreval ("Sua idade é: ",idade)
   se (idade<16) entao
         escreval ("Você não tem idade para votar")
         escreval ("Você não tem idade para dirigir")
   senao
   se (idade=16) ou (idade=17) entao
         escreval ("Você tem idade para votar")
         escreval ("Você não tem idade para dirigir")
   senao
   se (idade>=18) entao
      escreval ("Você tem idade para dirigir")
      escreval ("Você tem idade para votar")
   fimse
   fimse
   fimse
fimalgoritmo