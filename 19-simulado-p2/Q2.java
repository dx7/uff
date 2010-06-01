import java.io.*;
import java.util.*;

class Q2 {
  // supondo que o arquivo terá apenas inteiros positivos
  public static void contar() throws Exception {
    RandomAccessFile r = new RandomAccessFile("Q2-arquivo-de-contagem.bin", "rw");
    Scanner s = new Scanner(new File("Q2-arquivo-de-numeros.txt"));
    
    r.setLength(0);
    
    while (s.hasNextInt()) {
      int n = s.nextInt();
      
      r.seek(n*4);
      
      int qtd = 0;
      if (r.getFilePointer() < r.length()) {
        qtd = (int) r.readInt();
      }
      
      r.seek(n*4);
      r.writeInt(qtd+1);
    }
  }
  
  // métodos de teste
  public static void main(String[] args) throws Exception {
    contar();
    mostrar();
  }
  
  public static void mostrar() throws Exception {
    RandomAccessFile f = new RandomAccessFile("Q2-arquivo-de-contagem.bin", "r");
    f.seek(0);
    
    while (f.getFilePointer() < f.length()) {
      System.out.println(f.getFilePointer()/4 + ": " + f.readInt() + "x");
    }
    
    System.out.println();
    f.close();
  }
}