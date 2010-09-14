import java.io.*;

public class CriaEMostraArquivosDeObjetos {

  public static void main(String[] args) throws Exception {
    String filename = "file.bin";
    
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
    out.writeObject(new Jogador(10, 10, 195, 100, "Teste", "Atacante", 1.99));
    out.close();
    
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
    Jogador x = (Jogador) in.readObject();
    System.out.println(x);
  }
}