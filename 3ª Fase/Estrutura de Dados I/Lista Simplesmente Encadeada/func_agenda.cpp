//Aqui ficam as funções

#include "func_agenda.h"
#include <iostream>
#include <string>
#include <string.h>

using namespace std;

no *criar_no(int codigo, int telefone){
	no *novo = new no();
	novo->cod = codigo;
	novo->cel = telefone;
	cout << "Informe o nome: ";
	cin >> novo->nome;
	cout << "Informe o e-mail: ";
	cin >> novo->email;
	cout << "Informe o twitter: ";
	cin >> novo->twitter;
	fflush(stdin);
	
	
	novo->prox = NULL;

	return novo;
}

no *criarAgenda(){
	return NULL;
}

no *recriarAgenda(no *contato){
	
	no *a = contato;
	while(a != NULL){
		no *excluir = a;
		a = a->prox;
		delete(excluir);
	}
	return NULL;
}

no *buscaUltimo(no *contato){
  if(contato == NULL){
     return NULL;
  }

  no *n = contato;
  while(n->prox != NULL){
    n = n->prox;
  }
  return n;
}

no *insereNome(no *contato, int codigo, int telefone){
	no *novo = criar_no(codigo, telefone);
	
	if(contato == NULL){
		contato = novo;
	}else{
		no *ultimo = buscaUltimo(contato);
		ultimo->prox = novo;
	}
	return contato;
}

void listarAgenda(no *contato){
    if(contato == NULL){
    cout << "\nNao existem valores a serem consultados" << endl;
  	}else{
	while(contato != NULL){
		cout << "--Nome: " << contato->nome << "--" << endl;
		cout << "\nCodigo: " << contato->cod << endl;
		cout << "Telefone: " << contato->cel << endl;
		cout << "E-mail: " << contato->email << endl;
		cout << "Twitter: " << contato->twitter << endl;
		contato = contato->prox;
    }
  }
}

no *consulta(no *contato, int codigo, char *nome, int op){
	if(contato == NULL){
		cout << "A lista esta vazia" << endl; 
		return NULL;
	}
	
	if(op == 3){
		no *aux = contato;
		no *pai = NULL;
		while(aux != NULL){
			if(aux->cod == codigo){
				if(pai==NULL){
					cout << "\n--Nome: " << contato->nome << "--" << endl;
					cout << "\nCodigo: " << contato->cod << endl;
					cout << "Telefone: " << contato->cel << endl;
					cout << "E-mail: " << contato->email << endl;
					cout << "Twitter: " << contato->twitter << endl;
				}else{
					cout << "\n--Nome: " << aux->nome << "--" << endl;
					cout << "\nCodigo: " << aux->cod << endl;
					cout << "Telefone: " << aux->cel << endl;
					cout << "E-mail: " << aux->email << endl;
					cout << "Twitter: " << aux->twitter << endl;
				}
				cout << endl;
				system("pause");
				break;
			}
			pai = aux;
			aux = aux->prox;  
		}
		return contato;
	}
	
	if(op == 4){
		no *aux = contato;
		no *pai = NULL;
		
		while(aux != NULL){
			int res=0;
			for(int i=0; i<codigo; i++)
			{
				if(nome[i] == aux->nome[i]){
					res = 1;
				}
				else{
					res=0;
					break;
				}
			}
			if (res == 1){
				if(pai==NULL){
					cout << "\n--Nome: " << contato->nome << "--" << endl;
					cout << "\nCodigo: " << contato->cod << endl;
					cout << "Telefone: " << contato->cel << endl;
					cout << "E-mail: " << contato->email << endl;
					cout << "Twitter: " << contato->twitter << endl;
				}else{
					cout << "\n--Nome: " << aux->nome << "--" << endl;
					cout << "\nCodigo: " << aux->cod << endl;
					cout << "Telefone: " << aux->cel << endl;
					cout << "E-mail: " << aux->email << endl;
					cout << "Twitter: " << aux->twitter << endl;
				}
				cout << endl;
				system("pause");
				break;
			}
				pai = aux;
				aux = aux->prox;
		}
		return contato;
	}
}

void consultaQnt(no *contato)
{
	int reg=0;
	if(contato == NULL){
		cout << "A lista esta vazia" << endl; 
	}else{
	while(contato != NULL){
		reg++;
		contato = contato->prox;
    }
    cout << "A agenda tem " << reg << " contato(s)" << endl;
  }
}
