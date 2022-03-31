algoritmo "Sexo da pessoa"
var
   nome: caractere
   sexo: caractere
inicio
   escreval ("Digite seu nome: ")
   leia (nome)
   escreval ("Digite seu sexo: ")
   leia (sexo)
   se (sexo="Masculino") e (sexo="masculino") entao
      escreval ("Sr.",nome)
      senao
      se (sexo="Feminino") e (sexo="feminino") entao
      escreval ("Sra.",nome)
      fimse
      fimse
fimalgoritmo