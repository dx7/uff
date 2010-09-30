#include <stdlib.h>
#include <stdio.h>

struct no {
	int dado;
	struct no *prox;
};

typedef struct no fila;

int main (int argc, char const *argv[])
{
	fila *inicio;
	fila *fim;
	int i;
	
	inicio = NULL;
	fim = NULL;
	
	for(i = 0; i < 10; ++i)
	{
		inserir(inicio, fim, i);
	}
	
	mostrar(inicio);
	
	return 0;
}

int mostrar(fila *inicio)
{
	fila *aux;
	aux = inicio;
	
	while (aux != NULL)
	{
		printf("%d\n", aux->dado);
	}
	
	printf("Acabou\n");
	
	return 0;
}

int remover(fila *inicio)
{
	fila *aux;
	int elem = 0;
	
	if(inicio != NULL)
	{
		aux = inicio;
		inicio = inicio->prox;
		elem = aux->dado;
		free(aux);
	}
	
	return elem;
}

int inserir(fila *inicio, fila *fim, int elem)
{
	fila *aux;
	
	aux = (fila*) malloc(sizeof(fila));
	
	aux->dado = elem;
	aux->prox = NULL;
	
	if (inicio == NULL)
	{
		inicio = aux;
	}
	else
	{
		fim->prox = aux;
	}
	
	fim = aux;
}