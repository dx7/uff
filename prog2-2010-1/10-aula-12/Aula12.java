import java.io.*;
import javax.swing.*;

class Aula12 {
  public static void main(String[] args) throws Exception {
    // ler quantidade de números
    System.out.println("Arquivo:");
    createFile(10);
    show();
    
    System.out.println("\nOrdenado:");
    sort();
    show();
    
    System.out.println("\nBusca:");
    find();
  }
  
  public static void find() throws Exception {
    int find = gui();
    
    while (find >= 0) {
      System.out.println(binaryFind(find));
      find = gui();
    }
  }
  
  public static boolean binaryFind(int find) throws Exception {
    RandomAccessFile file = new RandomAccessFile("arquivo.txt", "r");
    
    long begin = 0;
    long end = file.length()-4;
    
    System.out.println("Buscar: " + find);
    
    while (begin < end) {
      file.seek(begin);
      System.out.print("início: " + file.readInt());
      
      file.seek(end);
      System.out.print(" - fim: " + file.readInt());
      
      long pointer = (((begin/4) + (end/4))/2)*4;
      // long pointer = (begin + end)/2;
      
      file.seek(pointer);
      
      int current = file.readInt();
      
      System.out.println(" - meio: " + current);
      
      if (find == current) return true;
      
      if (find < current)
        end = pointer-4;
      else
        begin = pointer;
    }
    
    file.close();
    return false;
  }
  
  public static void createFile(int qtd) throws Exception {
    RandomAccessFile file = new RandomAccessFile("arquivo.txt", "rw");
    
    for (int i=0; i < qtd; i++) file.writeInt((int) (Math.random()*100));
    
    file.close();
  }
  
  public static void sort() throws Exception {
    RandomAccessFile file = new RandomAccessFile("arquivo.txt", "rw");
    
    boolean swapped = true;
    int j = 0;
    
    while (swapped) {
      swapped = false;
      j++;
      
      for (int i = 0; i < (int) (file.length()/4 - j); i++) {
        file.seek(i*4);
        int first = file.readInt();
        int second = file.readInt();
        
        if (first > second) {
          file.seek(i*4);
          file.writeInt(second);
          file.writeInt(first);
          swapped = true;
        }
      }
    }
    
    file.close();
  }
  
  public static void show() throws Exception {
    RandomAccessFile file = new RandomAccessFile("arquivo.txt", "r");
    
    file.seek(0);
    
    while (file.getFilePointer() < file.length()) System.out.print(file.readInt() + " ");
    
    file.close();
  }
  
  public static int gui() throws Exception {
    String s = JOptionPane.showInputDialog("Buscar");
    
    if (s == null || s.isEmpty()) return -1;
    
    return Integer.parseInt(s);
  }
}

// remover repetidos