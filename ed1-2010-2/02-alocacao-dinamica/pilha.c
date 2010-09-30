/*
Algoritmo push(topo, elem)
	aux: pilha
	
	inicio
		ocupar(aux)
		aux->dado <- elem
		aux->prox <- topo
		topo <- aux
		
	fim
fim

Algoritmo pop(topo, elem)
	aux: pilha
	
	inicio
		se topo != nulo então
			aux <- topo
			topo <- topo->prox
			elem <- aux->dado
			desocupar(aux)
		senão
			'Pilha vazia'
		fim
	fim
fim
*/

struct no {
	int dado;
	struct no *prox;
}

typedef struct no pilha;

pilha *topo = null;
pilha *aux;
