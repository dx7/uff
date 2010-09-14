import java.io.*;
import java.util.*;

public class Q2 {
  public static void contar() throws Exception {
    Scanner s = new Scanner(new File("Q2-arquivo-de-numeros.txt"));
    
    while (s.hasNextInt()) inserir(s.nextInt());
    
    s.close();
  }
  
  public static long achar(int n) throws Exception {
    RandomAccessFile r = new RandomAccessFile("Q2-arquivo-de-contagem.bin", "r");
    long pos = -1;
    
    for (long i = 0; i < r.length() && pos == -1; i += 8) {
      r.seek(i);
      if (r.readInt() == n) pos = i;
    }
    
    r.close();
    return pos;
  }
  
  public static void inserir(int n) throws Exception {
    RandomAccessFile r = new RandomAccessFile("Q2-arquivo-de-contagem.bin", "rw");
    
    long pos = achar(n);
    
    if (pos == -1) { // nao foi encontrado, add no final
      r.seek(r.length());
      r.writeInt(n);
      r.writeInt(1);
    } else { // foi encontrado. add mais uma ocorrencia.
      r.seek(pos + 4);
      int ocorrencias = r.readInt() + 1;
      r.seek(pos + 4);
      r.writeInt(ocorrencias);
    }
    
    r.close();
  }
  
  // métodos de teste
  public static void main(String[] args) throws Exception {
    zerar();
    contar();
    mostrar();
  }
  
  public static void zerar() throws Exception {
    RandomAccessFile f = new RandomAccessFile("Q2-arquivo-de-contagem.bin", "rw");
    f.setLength(0);
    f.close();
  }
  
  public static void mostrar() throws Exception {
    RandomAccessFile f = new RandomAccessFile("Q2-arquivo-de-contagem.bin", "r");
    f.seek(0);
    
    while (f.getFilePointer() < f.length()) {
      System.out.println(f.readInt() + ": " + f.readInt() + "x");
    }
    
    System.out.println();
    f.close();
  }
}