import java.io.*;

class BuscaBinariaEmArquivo {
  
  public static void main(String[] args) throws Exception {
    criar();
    mostrar();
    
    System.out.println(buscar(1.0));
    System.out.println(buscar(9.0));
    System.out.println(buscar(5.0));
    System.out.println(buscar(10.0));
    System.out.println(buscar(-1.0));
  }
  
  public static void criar() throws Exception {
    RandomAccessFile f = new RandomAccessFile("arquivo.bin", "rw");
    
    for (double i=0; i < 10; i++) f.writeDouble(i);

    f.close();
  }
  
  public static void mostrar() throws Exception {
    RandomAccessFile f = new RandomAccessFile("arquivo.bin", "r");
    f.seek(0);
    
    while (f.getFilePointer() < f.length()) {
      System.out.print(f.readDouble() + " ");
    }
    
    System.out.println();
    f.close();
  }
  
  public static boolean buscar(double n) throws Exception {
    RandomAccessFile f = new RandomAccessFile("arquivo.bin", "r");
    
    long inicio = 0;
    long fim = f.length();
    boolean achou = false;
    
    while (inicio < fim-8 && !achou) {
      long meio = (long) ((((fim - inicio)/8)/2)*8)+inicio;
      f.seek(meio);
      
      double valorDoMeio = f.readDouble();
      
      if (n == valorDoMeio) {
        achou = true;
      } else {
        if (n < valorDoMeio) {
          fim = meio;
        } else {
          inicio = meio;
        }
      }
    }
    
    f.close();
    
    return achou;
  }
}