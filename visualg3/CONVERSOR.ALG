//Algoritmo que converte a tempertura de Fahrenheit para Celsius
algoritmo "Conversor"
var
//defini��o das viari�veis
	f, c : real
inicio
//pede a temperatura e armazena
	ESCREVA ("Digite o valor de Fahrenheit: ")
	LEIA (f)
//calcula a convers�o
	c <- (f-32)/1.8
   ESCREVA ("A temperatura em Celsius �:" ,c)
fimalgoritmo