public class Lista {
  
  static class Node {
    int value;
    Node next;
    
    public Node(int v, Node n) {
      value = v;
      next = n;
    }
    
    public Node(int v) {
      value = v;
    }
  }
  
  public static void main(String[] args) {
    Node n = initialize(10, null);
    System.out.println(toString(n));
    
    n = sort(n);
    System.out.println(toString(n));
    System.out.println(toStringInverse(n));
  }
  
  public static Node sort(Node n) {
    if(n.next == null) return n;
    
    boolean swap = true;
    Node current;
    
    while(swap) {
      swap = false;
      
      for (current = n; current.next != null; current = current.next) {
        if (current.value > current.next.value) {
          swap = true;
          int temp = current.value;
          current.value = current.next.value;
          current.next.value = temp;
        }
      }
    }
    
    return n;
  }
  
  public static Node initialize(int i, Node n) {
    if(i == 0) return new Node(i);
    return new Node((int)(Math.random()*10), initialize(i-1, null));
  }
  
  public static String toString(Node n) {
    if (n == null) return "";
    return n.value + " " + toString(n.next);
  }
  
  public static String toStringInverse(Node n) {
    if (n == null) return "";
    return toStringInverse(n.next) + n.value + " " ;
  }
}