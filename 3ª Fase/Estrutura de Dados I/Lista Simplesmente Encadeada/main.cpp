#include "func_agenda.h"
#include <iostream>
#include <string>
#include <string.h>

using namespace std;

void menu(){
	no *contato = NULL;
	int op = -1;
	int cod = 0, cel =0;
	char nome[30];
	while(op != 0){
		fflush(stdin);
    	system("cls");
		cout << "--Informe a opcao desejada da lista abaixo--\n" << endl;
		cout << "1. Criar agenda" << endl;
		cout << "2. Inserir nome na agenda" << endl;
		cout << "3. Consultar por codigo" << endl;
		cout << "4. Consultar por nome" << endl;
		cout << "5. Quantidade de nomes na agenda" << endl;
		cout << "6. Listar agenda" << endl;
		cout << "0. Sair" << endl;
		cout << "\nSua opcao: ";
		cin >> op;
		fflush(stdin);
		cout << "\n";
		
		switch(op){
			case 1: {
				if (contato != NULL){
					contato = recriarAgenda(contato);
				}else{
					contato = criarAgenda();
				}
				cout << "\n";
				break;
			}
			case 2: {
				cout << "Informe o codigo do contato: ";
				cin >> cod;
				cout << "Informe o telefone: ";
				cin >> cel;
				fflush(stdin);
			    
				contato = insereNome(contato, cod, cel);
				break;
			}
			case 3: {
				cout << "Informe o codigo que deseja buscar: ";
				cin >> cod;
				consulta(contato, cod, "", op);
				cout << endl;
				break;
			}
			case 4: {
				cout << "Informe o nome que deseja buscar: ";
				cin >> nome;
				int tam=strlen(nome);
				consulta(contato, tam, nome, op);
				cout << endl;
				break;
			}
			case 5: {
				consultaQnt(contato);
				cout << endl;
				system("pause");
				break;
			}
			case 6: {
				listarAgenda(contato);
				cout << endl;
				system("pause");
				break;
			}
			case 0: {
				break;
			}
			default: {
				cout << "Opcao invalida" << endl;
				cout << endl;
				system("pause");
				break;
			}
		}
	}
}

main(){
	menu();
	return 0;
}
