#include <stdio.h>

// Exemplo de uso de ponteiros

#include <stdio.h>
#include <stdlib.h>

struct no {
	int info;
	struct no *prox;
};

typedef struct no lista;

lista *l, *m;

int main (int argc, char const *argv[])
{
	l = (lista*) malloc(sizeof(lista)); // nó cabeça
	
	l->info = -9999;
	l->prox = NULL;
	
	printf("%d\n", l->info);
	
	m = (lista*) malloc(sizeof(lista));
	
	m->info = -9998;
	m->prox = l;
	
	int a = 9;
	int *p;
	p = &a;
	
	printf("%d\n", *p);
	
	*p = a;
	printf("%d\n", *p);
	
	printf("%d\n", m->info);
	
	printf("%d\n", m->prox->info);
	
	return 0;
}