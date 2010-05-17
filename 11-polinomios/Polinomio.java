class Polinomio {
  public int[][] coeficientes;
  
  public Polinomio(String p) {
    // String[] tmp = p.matches("^(\\+|\\-)?[0-9]+x\\^[0-9]+");
    // 
    // String t = "";
    // for(String c: tmp) t += c;
    // 
    // System.out.println(t);
    
    coeficientes = new int[100][2];
    coeficientes[0][0] = 5;
    coeficientes[0][1] = 3;
    
    coeficientes[1][0] = 71;
    coeficientes[1][1] = 2;
    
    coeficientes[2][0] = -1;
    coeficientes[2][1] = 0;
  }
  
  public int[] fator(String f) {
    String[] v = f.split("x\\^");
    
    int[] resp = new int[2];
    
    resp[0] = Integer.parseInt(v[0]);
    resp[1] = Integer.parseInt(v[1]);
    
    return resp;
  }
  
  public void soma(Polinomio p) {
    boolean ok = false;
    int tam = coeficientes.length > p.coeficientes.length ? coeficientes.length : p.coeficientes.length;
    int[] a = new int[tam][2];
    
    for (int i=0; i < p.coeficientes.length; i++) {
      for (int j=0; j < coeficientes.length; j++) {
        p[i] 
      }
    }
    
    for(int[] i: p.coeficientes) {
      for(int[] j: coeficientes) {
        if(i[1] == j[1]) {
          i[0] += j[0];
          ok = true;
          break; 
        }
      }
      
      if(ok) {
        ok = false;
      } else {
        coeficientes[][] = i;
      }
    }
    
    coeficientes = a;
  }
  
  public String toString() {
    String tmp = "";
    
    if (coeficientes != null) for(int[] fator: coeficientes) tmp += (fator[0] > 0 ? "+" : "") + fator[0] + "x^" + fator[1];
    
    return tmp;
  }
}