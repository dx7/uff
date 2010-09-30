/* Listas duplamente encadeadas.

Algoritmo InsereNo(l, elem)
Inicio
  busca(l, elem, ant, pont)
  
  se pont = nulo então
    ocupar(aux)
    aux->dado <- elem
    aux->prox <- ant->prox
    aux->pre <-ant
    ant->prox->pre <- aux
    ant->prox <- aux
  senão
    'Elemento já existe'
  fim-se
fim

Algoritmo RemoveNo(l, elem)
Início
  busca(l, elem, ant, pont)
  
  se pont != nulo então
    pont->pre->prox <- pont->prox
    pont->prox->pre <- pont->pre
    desocupar(pont)
  senão
    'Elemento não existe'
  fim-se
fim

// Fazer algoritmo de busca.

*/
