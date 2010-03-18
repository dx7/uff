class Node {
  public int number;
  public Node next;
  
  public Node() {
  }
  
  public Node(int n) {
    number = n;
  }
  
  public int car() { // retorna o valor do nó
    return number;
  }
  
  public Node cdr() { // retorna o próximo nó
    return next;
  }
  
  public static Node cons(int n) { // controi um nó - faz a mesma coisa que o construtor, por isso apenas chama o construtor
    return new Node(n);
  }
  
  public String toString() {
    if (next == null) return String.valueOf(number);
    return number + " -> " + next;
  }
}