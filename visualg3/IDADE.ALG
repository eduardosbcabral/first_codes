Algoritmo "Idade"
var
   nasc, idade : real
inicio
      escreval ("Informe seu ano de nascimento")
   leia(nasc)
   idade <- 2016-nasc
   escreval ("Sua idade �: ",idade)
   se (idade<16) entao
         escreval ("Voc� n�o tem idade para votar")
         escreval ("Voc� n�o tem idade para dirigir")
   senao
   se (idade=16) ou (idade=17) entao
         escreval ("Voc� tem idade para votar")
         escreval ("Voc� n�o tem idade para dirigir")
   senao
   se (idade>=18) entao
      escreval ("Voc� tem idade para dirigir")
      escreval ("Voc� tem idade para votar")
   fimse
   fimse
   fimse
fimalgoritmo