Algoritmo "Peso ideal"
var
   a, r : real
   s : caractere
inicio
   escreval ("Digite a sua altura: ")
   leia (a)
   escreval ("Digite o seu sexo M ou F: ")
   leia (s)
      se (s="M") e (s="m") entao
         r <- (72*a) - 58
            escreval ("O peso ideal é: ",r)
      senao
                    escreval ("O peso ideal é: ",r)
            fimse
fimalgoritmo
   
   