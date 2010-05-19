import java.util.*;
import java.io.*;

class Questao2 {
  public static void main(String[] args) throws Exception {
    Lista l = executar();
    mostrar(l);
  }
  
  public static Lista executar() throws Exception {
    Scanner f = new Scanner(new File("arquivo.txt"));
    Lista l = null;
    
    while (f.hasNextLine()) l = add(f.nextLine(), l);
    
    f.close();
    
    return l;
  }
  
  public static void mostrar(Lista l) throws Exception {
    if (l != null) {
      mostrar(l.prox);
      System.out.println("Palavra: " + l.info.palavra + " (" + l.info.contagem + "x)");
    }
  }
  
  public static Lista buscar(String p, Lista l) throws Exception {
    if (l == null) return null;
    if (l.info.palavra.equals(p)) return l;
    return buscar(p, l.prox);
  }
  
  public static Lista add(String p, Lista l) throws Exception {
    Lista no = buscar(p, l);
    
    if (no == null) {
      no = new Lista(new Descritor(p, 1));
      no.prox = l;
      return no;
    }
    
    no.info.contagem++;
    return l;
  }
}