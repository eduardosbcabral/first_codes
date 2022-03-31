Algoritmo "Mortalidade"
// Disciplina   : [Lógica de Programação]
//  
// Descrição   : Calcula diferentes informações sobre a mortalidade infantil
// Autor(a)    : Eduardo da Silva Barros Cabral
// Data atual  : 07/04/2016
Var
   nascidas  : inteiro // Número de crianças nascidas
   idade : inteiro // Idade das crianças nascidas
   i : inteiro // Total de crianças com idade menor que 24 meses
	masc, femin, total : real
	sexo : caractere // Sexo da criança

Inicio

   escreval ("**********Mortalidade infantil**********")
   escreval ("")
   
   repita
   
   // Entrada da informação da quantidade de crianças
         escreval ("")
   escreva ("Digite quantas crianças nasceram no período: ")
   leia(nascidas)
         escreval ("")

   // Verifica se nasceram crianças
   se (nascidas = 0) entao
      escreva ("Nenhuma criança nasceu.")
   senao

   //LOOP FOR - Para receber as informações das crianças
   para i de 1 ate nascidas faca
      escreva ("Digite o sexo (M ou F) da " ,i, "ª criança: ")
      leia (sexo)

      escreva ("Digite o tempo de vida (em meses) da " ,i, "ª criança: ")
      leia (idade)
            escreval ("")

         se (sexo = "f") ou (sexo = "F") entao
            femin <- femin + 1
            senao
            
               se (sexo = "m") ou (sexo = "M") entao
                  masc <- masc + 1
                  
                  se (idade <= 24) entao
                     total <- total + 1
                  fimse
               fimse
         fimse
   fimpara
   
      // Calcular a porcentagem de crianças
      femin <- (femin/nascidas)*100
      masc <- (masc/nascidas)*100
      total <- (total/nascidas)*100

      //Imprime na tela todas as respostas
      escreval ("Morreram " ,femin, "% de crianças do sexo feminino.")
      escreval ("Morreram " ,masc, "% de crianças do sexo masculino.")
      escreval ("Morreram " ,total, "% de crianças com 24 meses ou menos.")

   fimse
   ate nascidas = 0
   
Fimalgoritmo