class DemoNo {
  public static void main(String[] args) {
    No item;
    
    item = new No(13);
    item.proximo = new No(26);
    item.proximo.proximo = new No(39);
    
    System.out.println(item);
  }
}