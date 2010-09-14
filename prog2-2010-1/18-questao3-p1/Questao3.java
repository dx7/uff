import java.io.*;

class Questao3 {
  public static void main(String[] args) throws Exception {
    gerarArquivo();
    mostrarArquivo();
    
    // remover(99);
    
    remover(99, "inteiros.bin");
    
    mostrarArquivo();
  }
  
  public static void gerarArquivo() throws Exception {
    RandomAccessFile arquivo = new RandomAccessFile("inteiros.bin", "rw");
    
    // for (int i=0; i < 20; i++) arquivo.writeInt((int) (Math.random()*100));
    arquivo.writeInt(99);
    arquivo.writeInt(99);
    arquivo.writeInt(99);
    arquivo.writeInt(99);
    arquivo.writeInt(1);
    arquivo.writeInt(99);
    arquivo.writeInt(99);
    arquivo.writeInt(2);
    arquivo.writeInt(99);
    arquivo.writeInt(99);
    arquivo.writeInt(99);
    arquivo.setLength(arquivo.getFilePointer());
    
    arquivo.close();
  }
  
  public static void mostrarArquivo() throws Exception {
    RandomAccessFile arquivo = new RandomAccessFile("inteiros.bin", "r");
    
    while (arquivo.getFilePointer() < arquivo.length()) System.out.print(arquivo.readInt() + " ");
    System.out.println();
    
    arquivo.close();
  }
  
  public static void remover(int x, String nome) throws Exception {
    RandomAccessFile arq = new RandomAccessFile(nome, "rw");
    int atual;

    for (int p=0; p < arq.length()/4; p++) {
      arq.seek(p*4);
      atual = arq.readInt();

      if (atual == x) {
        for (int i = p + 1; i < (arq.length()/4); i++) {
          arq.seek(i*4);
          atual = arq.readInt();
          arq.seek((i-1)*4);
          arq.writeInt(atual);
        }
        arq.setLength(arq.length()-4);
      }
    }
  }
  
  // private static void remover(long pos) throws Exception {
  //   RandomAccessFile arquivo = new RandomAccessFile("inteiros.bin", "rw");
  //   
  //   if (pos+4 == arquivo.length()) {
  //     arquivo.setLength(pos);
  //     arquivo.close();
  //   } else {
  //     arquivo.seek(pos+4);
  //     int temp = arquivo.readInt();
  //     arquivo.seek(arquivo.getFilePointer()-8);
  //     arquivo.writeInt(temp);
  //     arquivo.close();
  //     remover(pos+4);
  //   }
  // }
  // 
  // public static void remover(int n) throws Exception {
  //   RandomAccessFile arquivo = new RandomAccessFile("inteiros.bin", "rw");
  //   
  //   for (long i = arquivo.length()-4; i >= 0; i=i-4) {
  //     arquivo.seek(i);
  //     if (n == arquivo.readInt()) remover(arquivo.getFilePointer()-4);
  //   }
  //   
  //   arquivo.close();
  // }
}