Algoritmo "M�dia escolar"
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
   escreval ("Voc� foi aprovado com m�dia: ",nf)
      senao
   escreval("Voc� est� de recupera��o com m�dia: ",nf)
   escreval ("Digite a nota do exame de recupera��o: ")
      leia (nexa)
   nfexa <- (nf+nexa)/2
      se (nfexa>=5) entao
   escreval ("Voc� foi aprovado depois do exame com m�dia: ",nfexa)
      senao
   escreval ("Voc� foi reprovado com m�dia: ",nfexa)
      fimse
      fimse
fimalgoritmo
