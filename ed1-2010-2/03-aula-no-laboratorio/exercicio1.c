#include <stdio.h>
#include <stdlib.h>

struct no {
	int info;
	struct no *prox;
};

typedef struct no lista;

lista *l;

int adicionar(int n)
{
	lista *aux = (lista*) malloc(sizeof(lista));

	aux->info = n;
	aux->prox = l->prox;
	l->prox = aux;
}

int mostrar()
{
	lista *aux = l->prox;
	
	while (aux != NULL)
	{
		printf("%d\n", aux->info);
		aux = aux->prox;
	}
}

lista* buscar(int n)
{
	lista *aux;
	aux = l->prox;
	int parar = 0;
	
	while (aux != NULL && !parar)
	{
		if(aux->info == n)
		{
			parar = 1;
		} else {
			aux = aux->prox;
		}
	}
	
	return aux;
}

int main (int argc, char const *argv[])
{
	lista *aux;
	
	l = (lista*) malloc(sizeof(lista)); // nó cabeça
	l->info = -9999;
	l->prox = NULL;
	
	adicionar(0);
	adicionar(1);
	adicionar(2);
	mostrar();
	
  aux = buscar(0); // comentando essa linha compila
	
	if(aux == NULL)
	{
		printf("Não encontrado.\n");
	}
	else
	{
		printf("%d\n", aux->info);
	}
	
	printf("%s\n", "Tudo ok até aqui!");
	return 0;
}
