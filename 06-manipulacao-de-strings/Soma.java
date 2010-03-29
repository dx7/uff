class Soma {
  public static void soma(String expressao) {
    String[] aux = expressao.split("\\+");
    
    double total = 0;
    
    for (int i=0; i < aux.length; i++) {
      total += Double.parseDouble(aux[i]);
    }
    
    System.out.println(total);
  }

  public static double somaRapida(String s) {
    int onde = s.indexOf("+");
    
    if (onde < 0) return Double.parseDouble(s);
    
    return Double.parseDouble(s.substring(0, onde)) + somaRapida(s.substring(onde+1));
  }
  
  public static void main(String[] args) {
    soma("10+10+10");
    soma("10+120.9+10");
    soma("10+10+10.9");
    soma("10+10+10.6");
    
    System.out.println(somaRapida("10+10+10"));
    System.out.println(somaRapida("10+120.9+10"));
    System.out.println(somaRapida("10+10+10.9"));
    System.out.println(somaRapida("10+10+10.6"));
  }
}