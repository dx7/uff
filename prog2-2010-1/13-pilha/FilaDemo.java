class FilaDemo {
  public static void main(String[] args) {
    Fila f = new Fila();
    
    f.enfila(11);
    f.enfila(26);
    f.enfila(59);
    f.enfila(100);
    
    f.mostrar();
    f.mostrar();
    f.mostrar();
  }
}

class Fila {
  private No primeiro, ultimo;
  private int total;
  
  public Fila() {
    total = 0;
  }
  
  public void mostrar() {
    No temp = primeiro;
    
    while (temp != null) {
      System.out.println(temp.info);
      temp = temp.prox;
    }
  }
  
  public void enfila(Object novo) {
    try {
      No temp = new No(novo);
      
      if (total == 0) {
        primeiro = ultimo = temp;
      } else {
        ultimo.prox = temp;
        ultimo = temp;
      }
      
      total++;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public boolean desenfila() {
    if (total == 0) return false;
    
    if (primeiro == ultimo)
      primeiro = ultimo = null;
    else
      primeiro = primeiro.prox;
    
    total--;
    return true;
  }
  
  public Object naFrente() {
    if (total == 0) return null;
    
    return primeiro.info;
  }
  
  public Object noFinal() {
    if (total == 0) return null;
    
    return ultimo.info;
  }
  
  public int tamanho() {
    return total;
  }
}