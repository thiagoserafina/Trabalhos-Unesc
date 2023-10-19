#include "headerEstoque.h"
#include <iostream>
#include <string>
#include <locale.h>


using namespace std;

ESTOQUE *resetarestoque(ESTOQUE *estoque){
    return NULL;
}

ESTOQUE *criar_no(int *n){
	ESTOQUE *novo = new ESTOQUE();
	novo->CD_PRODUTO = *n;
	
	cout << "Nome do produto: ";
	fflush(stdin);
    cin >> novo->DS_PRODUTO;
	cout << "Descrição: ";
	fflush(stdin);
	cin >> novo->DS_DESC;
	fflush(stdin);
	cout << "Quantidade: ";
	cin >> novo->UN_QTD;
	cout << "Preço: ";
	cin >> novo->UN_PRECO;
	
	if (novo->UN_QTD < 1)
	{
		novo->UN_FALTA = true;
	}
	
	novo->prox = NULL;
	*n=*n+1;
	
	return novo;
}

ESTOQUE *CADASTRO(ESTOQUE *estoque, int *n){
    ESTOQUE *novo = criar_no(n);
	 
	if(estoque == NULL){
		estoque = novo;
	}else{
		ESTOQUE *n = estoque;
		while(n->prox != NULL){
		n = n->prox;
		}
		n->prox = novo;
	}
	return estoque;   
}

ESTOQUE *REMOVER_CADASTRO(ESTOQUE *estoque, int codigo){
	
	ESTOQUE *aux = estoque;
	ESTOQUE *pai = NULL;
	
	while (aux != NULL){
		if(aux->CD_PRODUTO == codigo){
			if(pai==NULL){
				estoque=estoque->prox;
			}else{
				pai->prox = aux->prox;
			}
			delete(aux);
			break;
		}
		pai = aux;
		aux = aux->prox;
	}
	return estoque;
}

ESTOQUE *ADD_QNT(ESTOQUE *estoque, int codigo){
	
	int valor;
	ESTOQUE *aux = estoque;
	ESTOQUE *pai = NULL;
	
	while (aux != NULL){
		if(aux->CD_PRODUTO == codigo){
			cout << "\nNome: " << aux->DS_PRODUTO << endl;
			cout << "Quantidade atual: " << aux->UN_QTD << endl;
			cout << "\nInforme a quantidade que deseja adicionar: ";
			cin >> valor;
			aux->UN_QTD = aux->UN_QTD + valor;
			
			if (aux->UN_QTD > 0)
			{		
				aux->UN_FALTA = false;
			}
			
			cout << "Valor alterado para " << aux->UN_QTD << " com sucesso!\n" << endl;
			system("pause");
			break;
		}
		pai = aux;
		aux = aux->prox;
	}
	return estoque;
}

ESTOQUE *REMOVE_QNT(ESTOQUE *estoque, int codigo){
	
	int valor;
	ESTOQUE *aux = estoque;
	ESTOQUE *pai = NULL;
	
	while (aux != NULL){
		if(aux->CD_PRODUTO == codigo){
			cout << "\nNome: " << aux->DS_PRODUTO << endl;
			cout << "Quantidade atual: " << aux->UN_QTD << endl;
			
			if (aux->UN_FALTA == true)
			{		
				cout << "Não há itens para remover." << endl;
				system("pause");
				break;
			}
			
			cout << "\nInforme a quantidade que deseja remover: ";
			cin >> valor;
			aux->UN_QTD = aux->UN_QTD - valor;
			cout << "Valor alterado para " << aux->UN_QTD << " com sucesso!\n" << endl;
			
			if (aux->UN_QTD < 1)
			{		
				aux->UN_FALTA = true;
			}
			
			system("pause");
			break;
		}
		pai = aux;
		aux = aux->prox;
	}
	return estoque;
}

void consulta(ESTOQUE *estoque, int codigo){
		ESTOQUE *aux = estoque;
		ESTOQUE *pai = NULL;
		while(aux != NULL){
			if (aux->CD_PRODUTO == codigo){
				if(pai==NULL){
					cout << "\nNome: " << aux->DS_PRODUTO << endl;
					cout << "Codigo: " << aux->CD_PRODUTO << endl;
					cout << "Descrição: " << aux->DS_DESC << endl;
					cout << "Quantidade: " << aux->UN_QTD << endl;
					cout << "Preço: R$" << aux->UN_PRECO << endl;
               		if (estoque->UN_FALTA == 1){
                  		cout << "Esta em Falta? Sim"<< endl << endl;
               		}else {
                  		cout << "Esta em Falta? Não"<< endl << endl;
              		}
				}else{
					cout << "\nNome: " << aux->DS_PRODUTO << endl;
					cout << "Codigo: " << aux->CD_PRODUTO << endl;
					cout << "Descrição: " << aux->DS_DESC << endl;
					cout << "Quantidade: " << aux->UN_QTD << endl;
					cout << "Preço: R$" << aux->UN_PRECO << endl;
               if (estoque->UN_FALTA == 1){
                  cout << "Esta em Falta? Sim"<< endl << endl;
               }else {
                  cout << "Esta em Falta? Não"<< endl << endl;
               }
				}
				system("pause");
				break;
			}
		aux = aux->prox;
    	}
}

void consultaNome(ESTOQUE *estoque,string nomeProduto){
  while (estoque !=NULL) {
     if (estoque->DS_PRODUTO == nomeProduto){
         cout << endl;
         cout << "\nNome: " << estoque->DS_PRODUTO << endl;
			cout << "Codigo: " << estoque->CD_PRODUTO << endl;
			cout << "Descrição: " << estoque->DS_DESC << endl;
			cout << "Quantidade: " << estoque->UN_QTD << endl;
			cout << "Preço: R$" << estoque->UN_PRECO << endl;
        if (estoque->UN_FALTA == 1){
            cout << "Esta em Falta? Sim"<< endl << endl;
        }else {
            cout << "Esta em Falta? Não"<< endl << endl;
        }
        system("pause");
        break;
     }
     else {
        estoque = estoque->prox;
     }
  }
    if (estoque ==NULL) {
        cout << endl << "Não foi possivel encontrar nenhum produto com este nome" << endl << endl;
        system("pause");
    }
}

void ordenaAscCod(ESTOQUE *estoque){
   int trocar, i;
    struct ESTOQUE *aux;
    struct ESTOQUE *aux2 = NULL;
      if (estoque == NULL){
         return;
      }
        
      do {
         trocar = 0;
         aux = estoque;
   
         while (aux->prox != aux2)
         {
               if (aux->CD_PRODUTO > aux->prox->CD_PRODUTO)
               {
				 swap(aux->CD_PRODUTO, aux->prox->CD_PRODUTO);
				 swap(aux->DS_PRODUTO, aux->prox->DS_PRODUTO);
				 swap(aux->DS_DESC, aux->prox->DS_DESC);	
                 swap(aux->UN_PRECO, aux->prox->UN_PRECO);
				 swap(aux->UN_QTD, aux->prox->UN_QTD);
				 swap(aux->UN_FALTA, aux->prox->UN_FALTA);	
                  trocar = 1;
               }
               aux = aux->prox;
         }
         aux2 = aux;
      }
      while (trocar);
}

void ordenaAscPreco(ESTOQUE *estoque){
   int trocar, i;
    struct ESTOQUE *aux;
    struct ESTOQUE *aux2 = NULL;
      if (estoque == NULL){
         return;
      }
        
      do {
         trocar = 0;
         aux = estoque;
   
         while (aux->prox != aux2)
         {
               if (aux->UN_PRECO > aux->prox->UN_PRECO)
               {
				 swap(aux->CD_PRODUTO, aux->prox->CD_PRODUTO);
				 swap(aux->DS_PRODUTO, aux->prox->DS_PRODUTO);
				 swap(aux->DS_DESC, aux->prox->DS_DESC);	
                 swap(aux->UN_PRECO, aux->prox->UN_PRECO);
				 swap(aux->UN_QTD, aux->prox->UN_QTD);
				 swap(aux->UN_FALTA, aux->prox->UN_FALTA);
                 trocar = 1;
               }
               aux = aux->prox;
         }
         aux2 = aux;
      }
      while (trocar);
}

void consultaFaltaEstoque(ESTOQUE *estoque){
   ESTOQUE *aux = estoque;
   while(estoque != NULL){
      if (estoque->UN_FALTA == 1){
        cout << endl;
        cout << "Codigo: " << estoque->CD_PRODUTO << endl;
        cout << "Nome: " << estoque->DS_PRODUTO << endl;
        cout << "Descrição: " << estoque->DS_DESC << endl;
        cout << "Quantidade: " << estoque->UN_QTD << endl;
        cout << "Preço: " << estoque->UN_PRECO << endl;
      }
      aux = estoque;
      estoque = estoque->prox;
   }
   system("pause");
}

void consultaEstoque(ESTOQUE *estoque){
   ESTOQUE *aux = estoque;
   while(estoque != NULL){
      cout << endl;
        cout << "Codigo: " << estoque->CD_PRODUTO << endl;
        cout << "Nome: " << estoque->DS_PRODUTO << endl;
        cout << "Descrição: " << estoque->DS_DESC << endl;
        cout << "Quantidade: " << estoque->UN_QTD << endl;
        cout << "Preço: " << estoque->UN_PRECO << endl;
        if (estoque->UN_FALTA == 1){
            cout << "Esta em Falta? Sim"<< endl << endl;
        }else {
            cout << "Esta em Falta? Não"<< endl << endl;
        }
      aux = estoque;
      estoque = estoque->prox;
   }
   system("pause");
}
