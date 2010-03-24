import java.io.*;

class ListaOrdenadaDeCarros {
  public ListaDeCarros l;
  public int qtd;
  
  public boolean salvar(String arquivo) {
    try {
      ObjectOutputStream arq = new ObjectOutputStream(new FileOutputStream(arquivo));
      ListaDeCarros aux = l;
      
      while (aux != null) {
        arq.writeObject(aux.info);
        aux = aux.prox;
      }
      
      arq.close();
      
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  
  public boolean carregar(String arquivo) {
    try {
      ObjectInputStream arq = new ObjectInputStream(new FileInputStream(arquivo));
      
      l = null;
      qtd = 0;
      
      while (true) {
        insere((Carro) arq.readObject());
      }
    } catch (EOFException e) {
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  
  public boolean insere(Carro c) {
    if (qtd == 0 || c.placa.compareTo(l.info.placa) < 0) {
      l = new ListaDeCarros(c, l);
      qtd++;
      return true;
    }
    
    ListaDeCarros antes = l;
    ListaDeCarros depois = l.prox;
    
    if (antes.info.placa.equals(c.placa)) {
      return false;
    }
    
    while (depois != null && depois.info.placa.compareTo(c.placa) < 0) {
      antes = depois;
      depois = depois.prox;
    }
    
    if (depois == null || depois.info.placa.equals(c.placa)) {
      return false;
    }
    
    antes.prox = new ListaDeCarros(c, depois);
    qtd++;
    return true;
  }
  
  public boolean remove(Carro c) {
    if (l == null || l.info.placa.compareTo(c.placa) > 0) {
      return false;
    }
    
    if (l.info.placa.equals(c.placa)) {
      l = l.prox;
      return true;
    }
    
    ListaDeCarros antes = l;
    ListaDeCarros depois = l.prox;
    
    while (depois != null && depois.info.placa.compareTo(c.placa) < 0) {
      antes = depois;
      depois = depois.prox;
    }
    
    if (depois == null || depois.info.placa.equals(c.placa)) {
      return false;
    }
    
    qtd--;
    antes.prox = depois.prox;
    return true;
  }
  
  public static void consultar(Carro c) {
    
  }
  
  public String toString(){
     return "Esta lista ordenada possui "+qtd+" elementos "+"\n"+l; 
  }
}