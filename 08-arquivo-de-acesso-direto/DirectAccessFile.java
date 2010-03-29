import java.io.*;

class DirectAccessFile {
  private String filename;
  private RandomAccessFile file;
  
  public static void main(String[] args) {
    DirectAccessFile a = new DirectAccessFile("arquivo.txt");
    a.create();
    a.read();
  }
  
  public DirectAccessFile(String f) {
    filename = f;
  }
    
  public void load_for(String mode) {
    try {
      file = new RandomAccessFile(filename, mode);
    } catch (Exception e) {
      System.out.println(e + "\nErro ao acessar arquivo");
    }
  }
  
  public void create() {
    load_for("rw");
    
    try {
      for (int i = 10; i >= 0; i--) file.writeInt(i);
      file.close();
    } catch (Exception e) {
      System.out.println(e + "\nErro na criação do arquivo");
    }
  }
  
  public void read() {
    load_for("r");
    
    try {
      while (file.getFilePointer() < file.length()) System.out.println(file.readInt());
      file.close();
    } catch (Exception e) {
      System.out.println(e + "\nErro na leitura do arquivo");
    }
  }
}