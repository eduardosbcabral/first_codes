Algoritmo "Média escolar"
var
   n1, n2, n3, n4, nf, nexa, nfexa : real
inicio
   escreval ("Digite a nota do primeiro bimestre:")
      leia (n1)
   escreval ("Digite a nota do segundo bimestre:")
      leia (n2)
   escreval ("Digite a nota do terceiro bimestre:")
      leia (n3)
   escreval ("Digite a nota do quarto bimestre:")
      leia (n4)
   nf <- (n1+n2+n3+n4)/4
      se (nf>=7) entao
   escreval ("Você foi aprovado com média: ",nf)
      senao
   escreval("Você está de recuperação com média: ",nf)
   escreval ("Digite a nota do exame de recuperação: ")
      leia (nexa)
   nfexa <- (nf+nexa)/2
      se (nfexa>=5) entao
   escreval ("Você foi aprovado depois do exame com média: ",nfexa)
      senao
   escreval ("Você foi reprovado com média: ",nfexa)
      fimse
      fimse
fimalgoritmo
