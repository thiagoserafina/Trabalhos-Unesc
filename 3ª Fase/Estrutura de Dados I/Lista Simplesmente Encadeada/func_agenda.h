//Aqui ficam as headers das funções

struct no{
	int cod, cel;
	char nome[30], email[30], twitter[30];
	no *prox;
};

no *criarAgenda();

no *recriarAgenda(no *contato);

no *insereNome(no *contato, int codigo, int telefone);

no *buscaUltimo(no *contato);

no *consulta(no *contato, int codigo, char *nome, int op);

void consultaQnt(no *contato);

void listarAgenda(no *contato);
