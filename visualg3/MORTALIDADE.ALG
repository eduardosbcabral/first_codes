Algoritmo "Mortalidade"
// Disciplina   : [L�gica de Programa��o]
//  
// Descri��o   : Calcula diferentes informa��es sobre a mortalidade infantil
// Autor(a)    : Eduardo da Silva Barros Cabral
// Data atual  : 07/04/2016
Var
   nascidas  : inteiro // N�mero de crian�as nascidas
   idade : inteiro // Idade das crian�as nascidas
   i : inteiro // Total de crian�as com idade menor que 24 meses
	masc, femin, total : real
	sexo : caractere // Sexo da crian�a

Inicio

   escreval ("**********Mortalidade infantil**********")
   escreval ("")
   
   repita
   
   // Entrada da informa��o da quantidade de crian�as
         escreval ("")
   escreva ("Digite quantas crian�as nasceram no per�odo: ")
   leia(nascidas)
         escreval ("")

   // Verifica se nasceram crian�as
   se (nascidas = 0) entao
      escreva ("Nenhuma crian�a nasceu.")
   senao

   //LOOP FOR - Para receber as informa��es das crian�as
   para i de 1 ate nascidas faca
      escreva ("Digite o sexo (M ou F) da " ,i, "� crian�a: ")
      leia (sexo)

      escreva ("Digite o tempo de vida (em meses) da " ,i, "� crian�a: ")
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
   
      // Calcular a porcentagem de crian�as
      femin <- (femin/nascidas)*100
      masc <- (masc/nascidas)*100
      total <- (total/nascidas)*100

      //Imprime na tela todas as respostas
      escreval ("Morreram " ,femin, "% de crian�as do sexo feminino.")
      escreval ("Morreram " ,masc, "% de crian�as do sexo masculino.")
      escreval ("Morreram " ,total, "% de crian�as com 24 meses ou menos.")

   fimse
   ate nascidas = 0
   
Fimalgoritmo