class DemoPolinomio {
  public static void main(String[] args) {
    Polinomio p = new Polinomio("5x^3+71x^2-1x^0");
    Polinomio q = new Polinomio("5x^3+71x^2-1x^0");
    p.soma(q);
    System.out.println(p);
  }
}