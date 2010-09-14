import java.util.*;
import java.io.*;

class Questao2 {
  public static void main(String[] args) throws Exception {
    Lista lista = executar();
    mostrar(lista);
  }
  
  public static Lista executar() throws Exception {
    Scanner arquivo = new Scanner(new File("arquivo.txt"));
    Lista lista = null;
    
    while (arquivo.hasNextLine()) lista = adicionarPalavra(arquivo.nextLine(), lista);
    
    arquivo.close();
    
    return lista;
  }
  
  public static void mostrar(Lista lista) throws Exception {
    if (lista != null) {
      System.out.println("=> " + lista.info.palavra + " (" + lista.info.contagem + "x)");
      mostrar(lista.prox);
    }
  }
  
  public static Lista buscar(String palavra, Lista lista) throws Exception {
    if (lista == null) return null;
    if (lista.info.palavra.equals(palavra)) return lista;
    return buscar(palavra, lista.prox);
  }
  
  public static Lista adicionarPalavra(String palavra, Lista lista) throws Exception {
    Lista ponteiro = buscar(palavra, lista);
    
    if (ponteiro == null) {
      ponteiro = lista;
      Lista temp = null;
      
      while (ponteiro != null && ponteiro.info.palavra.compareTo(palavra) < 0) {
        temp = ponteiro;
        ponteiro = ponteiro.prox;
      }
      
      Lista novo = new Lista(new Descritor(palavra, 1));
      novo.prox = ponteiro;
      
      if (temp != null) temp.prox = novo;
      
      if (lista == null) lista = novo;
    } else {
      ponteiro.info.contagem++;
    }
    
    return lista;
  }
}