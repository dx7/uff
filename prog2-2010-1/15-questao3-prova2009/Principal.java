class Principal {
  
  public static void main(String[] args) {
    No no = constroi(10);
    
    System.out.println("Lista:");
    mostra(no);
    
    ordenaPorCodigo(no);

    System.out.println("Ordenada por código:");
    mostra(no);
    
    ordenaPorQuantidade(no);
    
    System.out.println("Ordenada por quantidade:");
    mostra(no);
  }
  
  public static No constroi(int totalDeProdutos) {
    No inicio = null, temp;
    
    for (int i = totalDeProdutos; i > 0; i--) {
      temp = new No(new Produto((int)(Math.random()*10), (Math.random()*100), (Math.random()*100)));
      temp.prox = inicio;
      inicio = temp;
    }
    
    return inicio;
  }

  public static void ordenaPorCodigo(No lista) {
    No p = lista;
    boolean trocou = true;
    
    while (trocou) {
      trocou = false;
      p = lista;
      
      while (p.prox != null) {
        if (p.info.cod > p.prox.info.cod) {
          Produto temp = p.info;
          p.info = p.prox.info;
          p.prox.info = temp;
          trocou = true;
        }
        p = p.prox;
      }
    }
  }

  public static void ordenaPorQuantidade(No lista) {
    No p = lista;
    boolean trocou = true;
    
    while (trocou) {
      trocou = false;
      p = lista;
      
      while (p.prox != null) {
        if (p.info.qtd < p.prox.info.qtd) {
          Produto temp = p.info;
          p.info = p.prox.info;
          p.prox.info = temp;
          trocou = true;
        }
        p = p.prox;
      }
    }  
  }
  
  public static void mostra(No lista) {
    while (lista != null) {
      System.out.print("[" + lista.info.cod + " - " + lista.info.qtd + "] ");
      lista = lista.prox;
    }
    System.out.println();
  }
}