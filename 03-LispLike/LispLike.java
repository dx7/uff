class LispLike {
  
  public static void main(String[] args) {
    No a = cons(13, cons(26, cons(39, null)));
    No b = cons(15, cons(13, cons(25, null)));
    No c = null;
    No d = cons(13, cons(25, null));
    No e = cons(13, a);
    
    System.out.println("a: " + a);
    System.out.println("b: " + b);
    System.out.println("c: " + c);
    System.out.println("d: " + d);
    System.out.println("e: " + e);
    System.out.println("a união b: " + uniao(a, b));
    System.out.println("26 pertence a a? " + pertence(26, a));
    System.out.println("26 pertence a b? " + pertence(26, b));
    System.out.println("a intersecao b: " + intersecao(a, b));
    System.out.println("a - b: " + diferenca(a, b));
    System.out.println("b - a: " + diferenca(b, a));
    System.out.println("a ordenado: " + ordena(a));
    System.out.println("b ordenado: " + ordena(b));
    System.out.println("insere 10 no final de a: " + insereNoFinal(10, a));
    System.out.println("inserir 10 em a: " + insere(10, a));
    System.out.println("inserir 20 em b: " + insere(20, b));
    System.out.println("somatório de a: " + soma(a));
    System.out.println("somatório de b: " + soma(b));
    System.out.println("tamanho a: " + tamanho(a));
    System.out.println("tamanho b: " + tamanho(b));
    System.out.println("a contem c: " + contem(a, c));
    System.out.println("a contem d: " + contem(a, d));
    System.out.println("b contem d: " + contem(b, d));
    System.out.println("a = a: " + iguais(a, a));
    System.out.println("a = b: " + iguais(a, b));
    System.out.println("inverte a: " + inverte(a));
    System.out.println("remove todos 13 de e: " + removeTodas(13, e));
    System.out.println("impares de a: " + impares(a));
    System.out.println("impares de b: " + impares(b));
    System.out.println("impares de c: " + impares(c));
    System.out.println("impares de d: " + impares(d));
    System.out.println("impares de e: " + impares(e));
    System.out.println("pares de a: " + pares(a));
    System.out.println("pares de b: " + pares(b));
    System.out.println("pares de c: " + pares(c));
    System.out.println("pares de d: " + pares(d));
    System.out.println("pares de e: " + pares(e));
    System.out.println("a append b:     " + append(a, b));
    System.out.println("a meu_append b: " + meu_append(a, b));
    System.out.println("fatorial de cada elemento da lista: FAZER! ");
  }
  
  public static No meu_append(No a, No b) {
    No ultimo = ultimo(a);
    if (vazia(ultimo)) return b;
    ultimo.proximo = b;
    return a;
  }
  
  public static No ultimo(No a) {
    if (vazia(a)) return null;
    if (cdr(a) == null) return a;
    return ultimo(cdr(a));
  }
  
  public static No append(No a, No b) {
    if (vazia(a)) return b;
    return cons(car(a), append(cdr(a), b));
  }
  
  public static No mistura(No a, No b) {
    if (vazia(a)) return b;
    if (vazia(b)) return a;
    if (car(a) < car(b)) return cons(car(a), mistura(cdr(a), b));
    
    return cons(car(b), mistura(a, cdr(b)));
  }
  
  public static No impares(No l) {
    if (vazia(l)) return null;
    
    if ((car(l) % 2) != 0) return cons(car(l), impares(cdr(l)));
    
    return impares(cdr(l));
  }
  
  public static No pares(No l) {
    if (vazia(l)) return null;
    
    if ((car(l) % 2) == 0) return cons(car(l), pares(cdr(l)));
    
    return pares(cdr(l));
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
    if (pertence(car(b), a)) return contem(a, cdr(b));
    return false;
  }
  
  public static No removeTodas(int x, No l) {
    if (vazia(l)) return null;
    
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
    return insereNoFinal(car(l), inverte(cdr(l)));
  }
  
  public static No insereNoFinal(int x, No l) {
    if (vazia(l)) return cons(x, null);
    return cons(car(l), insereNoFinal(x, cdr(l)));
  }
}