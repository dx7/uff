public class Q3 {

  public static int car(No l) {
    return (l.info);
  }

  public static No cdr(No l) {
    if (l == null) return null;
    return (l.prox);
  }

  public static No cons(int x, No l) {
    No nova = new No(x);
    nova.prox = l;
    return nova;
  }

  public static void mostra(No l) {
    No aux = l;
  
    while (aux != null) {
      System.out.print(car(aux) + " ");
      aux = cdr(aux);
    }
  
    System.out.println();
  }

  public static No insereOrdenado(int x, No l) {
    if (l == null || x < car(l)) return cons(x, l);
    
    return cons(car(l), insereOrdenado(x, cdr(l)));
  }

  public static No inverter(No l) {
    if (l == null) return null;

    return insereNoFinal(inverter(cdr(l)), car(l));
  }

  public static No insereNoFinal(No l, int x) {
    if (l == null) return cons(x, null);
    
    return cons(car(l), insereNoFinal(cdr(l), x));
  }

  public static boolean par(int x) {
    return x % 2 == 0;
  }

  public static No listaDeImpares(No l) {
    if (l == null) return null;
    
    if (par(car(l))) return listaDeImpares(cdr(l));
    
    return cons(car(l), listaDeImpares(cdr(l)));
  }

  public static No listaDePares(No l) {
    if (l == null) return null;
    
    if (par(car(l))) return cons(car(l), listaDePares(cdr(l)));
    
    return listaDePares(cdr(l));
  }
  
  public static No ordena(No l){
    if (l == null) return null;
    
    return insereOrdenado(car(l), ordena(cdr(l)));
  }

  public static boolean pertence(int x, No l){
    if (l == null) return false;

    if (x == car(l)) return true;

    return pertence(x,cdr(l));
  }

  public static No uniao(No l1, No l2){
    if (l1 == null) return l2;

    if (pertence (car(l1),l2)) return uniao(cdr(l1),l2);

    return cons(car(l1),uniao(cdr(l1),l2));
  }

  public static int somaEMult(int x1, int x2){
    return x1*x2;
  }

  public static int produtoEscalar(No l1, No l2){
    if (l1 == null) return 0;

    if (l2 == null) return 0;

    return (produtoEscalar(cdr(l1), cdr(l2)) + somaEMult(car(l1), car(l2)));
  }

  public static void main(String args[]){

    System.out.println("Lista 1: ");
    No lista = cons(1, cons(2, cons(3, cons(4, null))));
    mostra(lista);
    
    System.out.println("Lista 2: ");
    No listadois = cons(1, cons(2, cons(7, cons(3, null))));
    mostra(listadois);

    //------ Invertendo a Lista ---- //

    System.out.println("Lista 1 INVERTIDA: ");
    No lista2 = inverter(lista);
    mostra(lista2);
    
    System.out.println("Lista 1 IMPARES: ");
    No listaImpr = listaDeImpares(lista);
    mostra(listaImpr);
    
    System.out.println("Lista 1 IMPARES INVERTIDA: ");
    No lista3 = inverter(listaImpr);
    mostra(lista3);
    
    System.out.println("Lista 1 PARES: ");
    No listaPar = listaDePares(lista);
    mostra(listaPar);

    // ------ordenando duas listas ------ //

    System.out.println("Lista 1 ORDENADA: ");
    No l1 = ordena(lista);
    mostra(l1);
    
    System.out.println("Lista 2 ORDENADA: ");
    No l2 = ordena(listadois);
    mostra(l2);

    System.out.println("Uniao ordenada das 2 listas: ");
    No l3 = uniao(l1,l2);
    No l4 = ordena(l3);
    mostra(l4);

    //----Produto Escalar---//

    System.out.println("Produto escalar das listas: ");
    int l5 = produtoEscalar(lista, listadois);
    System.out.println(l5);
  }
}

class No {
  int info;
  No prox;

  public No(int i) {
    info = i;
    prox = null;
  }
}