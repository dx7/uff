class LispLike {
  
  public static void main(String[] args) {
    // No a = cons(13, cons(26, cons(39, null)));
    // No b = cons(15, cons(13, cons(25, null)));
    // System.out.println(item);
  }
  
  public static boolean vazia(No l) {
    return l == null;
  }
  
  public static int car(No l) { // retorna o valor de um nó
    return l.info;
  }
  
  public static No cdr(No l) { // retorna o próximo nó a partir do nó passado
    return l.proximo;
  }
  
  public static No cons(int x, No l) { // controi um nó e add na lista
    No nova = new No(x);
    nova.proximo = l;
    return nova;
  }
  
  public static No uniao(No a, No b) {
    if (vazia(a)) return b;
    
    if (pertence(car(a), b)) return uniao(cdr(a), b);
    
    return cons(car(a), uniao(cdr(a), b));
  }
  
  public static boolean pertence(int x, No l) {
    if (vazia(l)) return false;
    
    if (car(l) == x) return true;
    
    return pertence(x, cdr(l));
  }
  
  public static No intersecao(No a, No b) {
    if (vazia(a)) return null;
    
    if (pertence(car(a), b)) return cons(car(a), intersecao(cdr(a), b));
    
    return intersecao(cdr(a), b);
  }
  
  public static No diferenca(No a, No b) {
    if (vazia(a)) return null;
    
    if (pertence(car(a), b)) return diferenca(cdr(a), b);
    
    return cons(car(a), diferenca(cdr(a),b));
  }
  
  public static No ordena(No l) { // insertion sort
    if (vazia(l)) return null;
    return insere(car(l), ordena(cdr(l)));
  }
  
  public static No insere(int x, No l) {
    if (vazia(l)) return cons(x, null);
    
    if (x < car(l)) return cons(x, l);
    
    return cons(car(l), insere(x, cdr(l)));
  }
  
  public static int soma(No l) {
    if (vazia(l)) return 0;
    return car(l) + soma(cdr(l));
  }
  
  public static int tamanho(No l) {
    if (vazia(l)) return 0;
    return 1 + tamanho(cdr(l));
  }
  
  public static boolean contem(No a, No b) {
    if (vazia(b)) return true;
    if (perntecen(car(b), a)) return contem(a, cdr(b));
    return false;
  }
  
  public static No removeTodas(int x, No l) {
    if (vazia(x)) return null;
    
    if (x == car(l)) return removeTodas(x, cdr(l));
    
    return cons(car(l), removeTodas(x, cdr(l)));
  }
  
  public static boolean iguais(No a, No b) {
    if (vazia(b)) return tamanho(b) == 0;
    if (vazia(b)) return false;
    return (car(a) == car(b)) && iguais(cdr(a), cdr(b));
  }
  
  public static No inverte(No l) {
    if (vazia(l)) return null;
    return insereNoFinal(inverte(cdr(l), car(l)));
  }
  
  public static No insereNoFinal(No l, int x) {
    if (vazia(l)) retunr cons(x, null);
    return cons(car(l), insereNoFinal(cdr(l), x));
  }
}