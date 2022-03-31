#include <iostream>
#include <stdlib.h>

using namespace std;

int main() {
	setlocale (LC_ALL , "portuguese");

	int nascidas; // Número de crianças nascidas
    int idade; // Idade das crianças nascidas
    int i; // loop for; // Total de crianças com idade menor que 24 meses
	float masc = 0, femin = 0, total = 0;
	char sexo; // Sexo da criança

	// Entrada da informação da quantidade de crianças
	cout << "Digite quantas crianças nasceram no período: ";
	cin >> nascidas;
	cout << endl;

	// Verifica se nasceram crianças
	if (nascidas == 0)
        cout << "Nenhuma criança nasceu." << endl;
    else {

        //LOOP FOR - Para receber as informações das crianças
        for (i = 1; i <= nascidas; i++){
            cout << "Digite o sexo (M ou F) da " << i << "ª criança: ";
            cin >> sexo;

            cout << "Digite o tempo de vida (em meses) da " << i << "ª criança: ";
            cin >> idade;
            cout << endl;

            if (sexo == 'F' || sexo == 'f')
                femin++;
            else if (sexo == 'M' || sexo == 'm')
                masc++;
            if (idade <= 24)
                total++;
        }

        // Calcular a porcentagem de crianças
        femin = (femin/nascidas)*100;
        masc = (masc/nascidas)*100;
        total = (total/nascidas)*100;


        //Imprime na tela todas as respostas
        cout << "Morreram " << femin << "% de crianças do sexo feminino." << endl;
        cout << "Morreram " << masc << "% de crianças do sexo masculino." << endl;
        cout << "Morreram " << total << "% de crianças com 24 meses ou menos." << endl;
    }
	system ("pause");
	return 0;
}
