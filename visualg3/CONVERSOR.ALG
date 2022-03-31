//Algoritmo que converte a tempertura de Fahrenheit para Celsius
algoritmo "Conversor"
var
//definição das viariáveis
	f, c : real
inicio
//pede a temperatura e armazena
	ESCREVA ("Digite o valor de Fahrenheit: ")
	LEIA (f)
//calcula a conversão
	c <- (f-32)/1.8
   ESCREVA ("A temperatura em Celsius é:" ,c)
fimalgoritmo