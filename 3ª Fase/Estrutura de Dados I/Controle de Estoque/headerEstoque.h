#include <string>
#ifndef HEADERESTOQUE_INCLUDED
#define HEADERESTOQUE_INCLUDED

using namespace std;

struct ESTOQUE {
    int CD_PRODUTO; //Codigo do Produto
    string DS_PRODUTO; //Nome do Produto
    string DS_DESC; //Descricao do produto
    int UN_QTD; //Quantidade no estoque do produto
    double UN_PRECO; //Preco do produto
    int UN_FALTA; //Ver se o estoque esta em falta ou nao
    struct ESTOQUE *prox;
};

ESTOQUE *resetarestoque(ESTOQUE *estoque);
ESTOQUE *CADASTRO(ESTOQUE *estoque, int *n);
ESTOQUE *REMOVER_CADASTRO(ESTOQUE *estoque, int codigo);
ESTOQUE *ADD_QNT(ESTOQUE *estoque, int codigo);
ESTOQUE *REMOVE_QNT(ESTOQUE *estoque, int codigo);
void consulta(ESTOQUE *estoque, int codigo);
void consultaNome(ESTOQUE *estoque,string nomeProduto);
void ordenaAscCod(ESTOQUE *estoque);
void ordenaAscPreco(ESTOQUE *estoque);
void consultaFaltaEstoque(ESTOQUE *estoque);
void consultaEstoque(ESTOQUE *estoque);

#endif