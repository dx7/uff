import java.io.*;

public class CriaEMostraArquivosDeObjetos {
  public static void main(String[] args) {
    String filename = "/tmp/teste.txt";
    
    try {
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
    
      out.writeObject(new Jogador(10, 10, 195, 100, "Teste", "Atacante", 1.99));
      out.close();
    } catch (Exception e) {
      System.out.println("Erro na gravação do arquivo");
    }
    
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
      Jogador x = (Jogador) in.readObject();
      System.out.println(x);
    } catch (Exception e) {
      System.out.println("Erro na leitura do arquivo");
    }
  }
}