class Node {
  public Object object;
  public Node next;
  
  public Node() {
  }
  
  public Node(Object o) {
    object = o;
  }
  
  public Object car() { // retorna o valor do nó
    return object;
  }
  
  public Node cdr() { // retorna o próximo nó
    return next;
  }
  
  public static Node cons(Object o) { // controi um nó - faz a mesma coisa que o construtor, por isso apenas chama o construtor
    return new Node(o);
  }
  
  public String toString() {
    if (next == null) return object.toString();
    return object + " -> " + next;
  }
}