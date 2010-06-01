import java.io.*;

class Q2 {
  public static void main(String[] args) throws Exception {
    zerar("q3.bin"); 
    mostrar("q3.bin");
    
    inserir("q3.bin", 10, 0);
    mostrar("q3.bin");
    
    inserir("q3.bin", 20, 1);
    mostrar("q3.bin");
    
    inserir("q3.bin", 30, 0);
    mostrar("q3.bin");
    
    inserir("q3.bin", 40, 15);
    mostrar("q3.bin");
    
  }
  
  public static void zerar (String nome) throws Exception {
    RandomAccessFile f = new RandomAccessFile(nome, "rw");
    f.setLength(0);
    f.close();
  }
  
  public static void inserir (String nome, int val, int pos) throws Exception {
    RandomAccessFile f = new RandomAccessFile(nome, "rw");
    f.seek(pos*4);
    
    while (f.getFilePointer() < f.length()) {
      int n = f.readInt();
      f.seek(pos*4);
      f.writeInt(val);
      pos++; val = n; f.seek(pos*4);
    }
    
    f.writeInt(val);
    f.close();
  }
  
  public static void mostrar(String nome) throws Exception {
    RandomAccessFile arquivo = new RandomAccessFile(nome, "r");
    
    while (arquivo.getFilePointer() < arquivo.length()) System.out.print(arquivo.readInt() + " ");
    System.out.println();
    
    arquivo.close();
  }
}