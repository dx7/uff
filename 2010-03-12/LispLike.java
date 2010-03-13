class LispLike {
  public static boolean vazia(No l) {
    return l == null;
  }
  
  public static int car(No l) {
    return l.info;
  }
  
  public static No cdr(No l) {
    return l.proximo;
  }
  
  public static No cons(int x, No l) {
    No nova = new No(x);
    nova.proximo = l;
    return nova;
  }
  
  public static void main(String[] args) {
    No a = cons(13, cons(26, cons(39, null)));
    No b = cons(15, cons(13, cons(25, null)));
    No c = 
    System.out.println(item);
  }
}