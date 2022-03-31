#include <iostream>
#include <stdlib.h>

using namespace std;

int main() {
	setlocale (LC_ALL , "portuguese");

	int nascidas; // N�mero de crian�as nascidas
    int idade; // Idade das crian�as nascidas
    int i; // loop for; // Total de crian�as com idade menor que 24 meses
	float masc = 0, femin = 0, total = 0;
	char sexo; // Sexo da crian�a

	// Entrada da informa��o da quantidade de crian�as
	cout << "Digite quantas crian�as nasceram no per�odo: ";
	cin >> nascidas;
	cout << endl;

	// Verifica se nasceram crian�as
	if (nascidas == 0)
        cout << "Nenhuma crian�a nasceu." << endl;
    else {

        //LOOP FOR - Para receber as informa��es das crian�as
        for (i = 1; i <= nascidas; i++){
            cout << "Digite o sexo (M ou F) da " << i << "� crian�a: ";
            cin >> sexo;

            cout << "Digite o tempo de vida (em meses) da " << i << "� crian�a: ";
            cin >> idade;
            cout << endl;

            if (sexo == 'F' || sexo == 'f')
                femin++;
            else if (sexo == 'M' || sexo == 'm')
                masc++;
            if (idade <= 24)
                total++;
        }

        // Calcular a porcentagem de crian�as
        femin = (femin/nascidas)*100;
        masc = (masc/nascidas)*100;
        total = (total/nascidas)*100;


        //Imprime na tela todas as respostas
        cout << "Morreram " << femin << "% de crian�as do sexo feminino." << endl;
        cout << "Morreram " << masc << "% de crian�as do sexo masculino." << endl;
        cout << "Morreram " << total << "% de crian�as com 24 meses ou menos." << endl;
    }
	system ("pause");
	return 0;
}
