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
  
  public static No impares(No l) {
    if (l == null) return null;
    
    if (car(l) % 2 != 0) return cons(car(l), impares(cdr(l)));
    
    return impares(cdr(l));
  }
  
  public static No pares(No l) {
    if (l == null) return null;
    
    if (car(l) % 2 == 0) return cons(car(l), pares(cdr(l)));
    
    return pares(cdr(l));
  }
  
  public static No inverter(No l) {
    if (l == null) return null;
    
    return inserirNoFinal(car(l), inverter(cdr(l)));
  }
  
  public static No inserirNoFinal(int x, No l) {
    if (l == null) return cons(x, null);
    
    return cons(car(l), inserirNoFinal(x, cdr(l)));
  }
  
  public static No inserirOrdenado(int x, No l) {
    if (l == null) return cons(x, null);
    
    if (x <= car(l)) return cons(x, l);
    
    return cons(car(l), inserirOrdenado(x, cdr(l)));
  }
  
  public static No ordenar(No l) {
    if (l == null) return null;
    
    return inserirOrdenado(car(l), ordenar(cdr(l)));
  }
  
  public static No unir(No a, No b) {
    if (a == null) return b;
    
    return inserirOrdenado(car(a), unir(cdr(a), b));
  }
  
  public static int escalar(No a, No b) {
    if (a == null || b == null || a.length() != b.length()) return 0;
    
    return escalar(cdr(a), cdr(b)) + car(a) * car(b);
  }

  public static void main(String[] args) {
    No l1 = cons(4, cons(5, cons( 2, cons(1, cons(0, cons(3, null))))));
    No l2 = cons(5, cons(7, cons( 6, cons(8, cons(9, cons(4, null))))));
    
    System.out.println("Listas: ");
    l1.mostrar();
    l2.mostrar();
    
    System.out.println("Tamanho das listas: ");
    System.out.println(l1.length());
    System.out.println(l2.length());
    
    System.out.println("Listas invertidas: ");
    inverter(l1).mostrar();
    inverter(l2).mostrar();
    
    System.out.println("Ímpares: ");
    impares(l1).mostrar();
    impares(l2).mostrar();
    
    System.out.println("Ímpares invertidos: ");
    inverter(impares(l1)).mostrar();
    inverter(impares(l2)).mostrar();
    
    System.out.println("Pares: ");
    pares(l1).mostrar();
    pares(l2).mostrar();
    
    System.out.println("Adicionado ordenadamente -1 e 10 nas listas: ");
    inserirOrdenado(10, inserirOrdenado(-1, l1)).mostrar();
    inserirOrdenado(10, inserirOrdenado(-1, l2)).mostrar();
    
    System.out.println("Listas ordenadas: ");
    ordenar(l1).mostrar();
    ordenar(l2).mostrar();
    
    System.out.println("União das listas ordenadas: ");
    unir(ordenar(l1), ordenar(l2)).mostrar();
    
    System.out.println("Produto escalar das listas: ");
    System.out.println(escalar(l1, l2));
    
    System.out.println("Produto escalar de listas de tamanhos diferentes: ");
    System.out.println(escalar(l1, inserirOrdenado(-1, l2)));
  }
}

class No {
  int info;
  No prox;

  public No(int i) {
    info = i;
  }
  
  public String toString() {
    if (prox == null) return String.valueOf(info);
    return info + " " + prox;
  }
  
  public int length() {
    if (prox == null) return 1;
    return 1 + prox.length();
  }
  
  public void mostrar() {
    System.out.println(this);
  }
}