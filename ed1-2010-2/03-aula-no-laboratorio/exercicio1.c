#include <stdio.h>
#include <stdlib.h>

struct no {
	int info;
	struct no *prox;
};

typedef struct no lista;

lista *l;

int main (int argc, char const *argv[])
{
	lista *achado;
	
	l = (lista*) malloc(sizeof(lista)); // nó cabeça
	l->info = -9999;
	l->prox = NULL;
	
	adicionar(0);
	mostrar();
	achado = buscar(0);
	// printf("%d\n", achado->info);
	
	printf("%s\n", "Tudo ok até aqui!");
	return 0;
}

adicionar(int n)
{
	lista *aux = (lista*) malloc(sizeof(lista));

	aux->info = n;
	aux->prox = l->prox;
	l->prox = aux;
}

mostrar()
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

// exemplo
// 
// 	l = (lista*) malloc(sizeof(lista)); // nó cabeça
// 	
// 	l->info = -9999;
// 	l->prox = NULL;
// 	
// 	printf("%d\n", l->info);
// 	
// 	m = (lista*) malloc(sizeof(lista));
// 	
// 	m->info = -9998;
// 	m->prox = l;
// 	
// 	int a = 9;
// 	int *p;
// 	p = &a;
// 	
// 	printf("%d\n", *p);
// 	
// 	*p = a;
// 	printf("%d\n", *p);
// 	
// 	printf("%d\n", m->info);
// 	
// 	printf("%d\n", m->prox->info);
