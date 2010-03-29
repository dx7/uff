import javax.swing.*;
import java.util.*;
import java.io.*;

class TextFile {
  String filename;
  
  public static void main(String[] args) {
    TextFile file = new TextFile("arquivo-texto.txt");
    file.create();
    file.read();
  }
  
  public TextFile(String f) {
    filename = f;
  }
  
  public void choose() {
    // filename = JOptionPane.showInputDialog("Nome do arquivo");
    filename = "arquivo-texto.txt";
    
    if (filename == null || filename.isEmpty()) System.out.println("Arquivo inválido");
  }
  
  public void read() {
    try {
      Scanner scanner = new Scanner(new File(filename));
      
      while (scanner.hasNextLine()) System.out.println(scanner.nextLine());
      
      scanner.close();
      System.out.println("Fim do arquivo");
    } catch (Exception e) {
      System.out.println("Erro na leitura do arquivo");
    }
  }
  
  public void create() {
    try {
      Formatter formatter = new Formatter(filename);
      
      // String line = JOptionPane.showInputDialog("Linha:");
      String line = "00000000000000000000";
      
      while (!line.isEmpty() && line != null) {
        formatter.format(line + "\n");
        // line = JOptionPane.showInputDialog("Linha:");
        line = line.substring(0, line.length()-1);
      }
      
      formatter.close();
      
      System.out.println("Arquivo criado");
    } catch (Exception e) {
      System.out.println("Erro ao gerar arquivo");
    }
  }
}