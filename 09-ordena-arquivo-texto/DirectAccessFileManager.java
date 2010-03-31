import java.io.*;

class DirectAccessFileManager {
  private RandomAccessFile file;
  
  public static void main(String[] args) throws Exception {
    DirectAccessFileManager a = new DirectAccessFileManager("arquivo.txt");
    
    a.create();

    System.out.println("Números aleatórios: ");
    a.read();

    System.out.println("Ordenando: ");
    int c = a.bubbleSort();
    System.out.println("Passos: " + c);
    
    System.out.println("Números ordenados: ");
    a.read();
    
    a.close();
  }
  
  public DirectAccessFileManager(String filename) throws Exception {
    file = new RandomAccessFile(filename, "rw");
  }
  
  public void close() throws Exception {
    file.close();
  }
    
  public void create() throws Exception {
    for (int i = 0; i < 1000; i++) file.writeInt((int) (Math.random()*100));
  }
  
  public void read() throws Exception {
    file.seek(0);
    
    System.out.print("[ ");
    
    while (file.getFilePointer() < file.length()) System.out.print(file.readInt() + " ");
    
    System.out.println("]");
  }
  
  public int length() throws Exception {
    return (int) (file.length() / 4);
  }
  
  public int bubbleSort() throws Exception {
    boolean swapped = true;
    int j = 0;
    int counter = 0;
    
    while (swapped) {
      swapped = false;
      j++;
      
      for (int i = 0; i < length() - j; i++) {
        file.seek(i*4);
        int one = file.readInt();
        int two = file.readInt();
        
        if (one > two) {
          file.seek(i*4);
          file.writeInt(two);
          file.writeInt(one);
          swapped = true;
          counter++;
        }
      }
    }
    return counter;
  }
}

// contar palavras em arquivo texto
// ordenar arquivo tipado