#include "headerEstoque.h"
#include <iostream>
#include <string>
#include <locale.h>

using namespace std;

void menuEstoque();

int main(int argc, char** argv) {
	setlocale(LC_ALL, "Portuguese");
	menuEstoque();
	return 0;
}
void menuEstoque(){
	ESTOQUE* estoque;
	estoque = resetarestoque(estoque);
	int menu = -1;
    int cod = 1;
	int codigo=0;
	string nome;

        cout << "1 - Criar produto no Estoque" << endl;
        cout << "2 - Remover produto no Estoque" << endl;
        cout << "3 - Adicionar quantidade em um estoque" << endl;
        cout << "4 - Remover quantidade em um estoque" << endl;
        cout << "5 - Pesquisar produto por código" << endl;
        cout << "6 - Pesquisar produto por nome" << endl;
        cout << "7 - Mostrar lista de produtos em ordem crescente de código" << endl;
		cout << "8 - Mostrar lista de produtos em ordem crescente de preço" << endl;
		cout << "9 - Mostrar lista de produtos com falta de estoque" << endl;
		cout << "10 - Resetar lista de Estoque" << endl;
        cout << "0 - Sair" << endl;
        cout << "Resposta: ";
        cin >> menu;

    while(menu!=0){

        switch(menu){
            case 1:
                estoque = CADASTRO(estoque, &cod);
                break;
            case 2:
				if (estoque==NULL){
					cout << endl << "Estoque Vazio" << endl;
					system("pause");
					break;
				} else {
					cout << "Informe o código do produto: ";
					cin >> codigo;
					estoque = REMOVER_CADASTRO(estoque, codigo);
                	break;
				}
            case 3:
				if (estoque==NULL){
					cout << endl << "Estoque Vazio" << endl;
					system("pause");
					break;
				}else {
					cout << "Informe o código do produto: ";
					cin >> codigo;
					estoque = ADD_QNT(estoque, codigo);          
                	break;	
				}
            case 4:
				if (estoque==NULL){
					cout << endl << "Estoque Vazio" << endl;
					system("pause");
					break;
				} else {
					cout << "Informe o código do produto: ";
					cin >> codigo;
					estoque = REMOVE_QNT(estoque, codigo);
                	break;
				}
            case 5:
				if (estoque==NULL){
					cout << endl << "Estoque Vazio" << endl;
					system("pause");
					break;
				} else {
					cout << "Informe o código do produto: ";
					cin >> codigo;
					consulta(estoque, codigo);
                	break;
				}
            case 6:
				if (estoque==NULL){
					cout << endl << "Estoque Vazio" << endl;
					system("pause");
					break;
				} else {
					cout << "Digite um nome de produto: "<< endl;
					cin>> nome;
					consultaNome(estoque, nome);
					break;
				}
            case 7:
				if (estoque==NULL){
					cout << endl << "Estoque Vazio" << endl;
					system("pause");
					break;
				} else {
					ordenaAscCod(estoque);
					consultaEstoque(estoque);
					break;
				}
            case 8:
				if (estoque==NULL){
					cout << endl << "Estoque Vazio" << endl;
					system("pause");
					break;
				} else {
					ordenaAscPreco(estoque);
					consultaEstoque(estoque);
					break;
				}
			case 9:
				if (estoque==NULL){
					cout << endl << "Estoque Vazio" << endl;
					system("pause");
					break;
				} else {
					ordenaAscCod(estoque);
					consultaFaltaEstoque(estoque);
					break;
				}
			case 10:
				estoque = resetarestoque(estoque);
				cod = 1;
				break;
            case 0: exit(0);
            default:
				cout << endl << "Opção inválida" << endl;
				cout << endl;
				system("pause");
				break; 
        }
        system("cls");
        cout << "1 - Criar produto no Estoque" << endl;
        cout << "2 - Remover produto no Estoque" << endl;
        cout << "3 - Adicionar quantidade em um estoque" << endl;
        cout << "4 - Remover quantidade em um estoque" << endl;
        cout << "5 - Pesquisar produto por codigo" << endl;
        cout << "6 - Pesquisar produto por nome" << endl;
        cout << "7 - Mostrar lista de produtos em ordem crescente de código" << endl;
		cout << "8 - Mostrar lista de produtos em ordem crescente de preço" << endl;
		cout << "9 - Mostrar lista de produtos com falta de estoque" << endl;
		cout << "10 - Resetar lista de Estoque" << endl;
        cout << "0 - Sair" << endl;
        cout << "Resposta: ";
        cin >> menu;
    }
}
