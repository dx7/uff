/* Lista encadeada com nó cabeça 

Algoritmo inserir(l, elem)
Inicio
	busca(l, elem, ant, pont)

	se pont = nulo então
		ocupar(aux)
		aux->dado <- elem
		aux->prox <- ant->prox
		ant->prox <- aux
	senão
		'Elemento já existe'
	fim-se
fim

Algoritmo remover(l, elem)
Início
	busca(l, elem, ant, pont)
	
	se pont != nulo então
		ant->prox <- pont->prox
		desocupar(pont)
	senão
		'Elemento não existe'
	fim-se
fim

// Fazer algoritmo de busca.

*/

