class ArraySort {
  public static void main(String[] args) {
    int[] original = {12, 45, 65, 76, 87, 34, 0, 99, 2, 45};
    int[] ordenado = {0, 2, 12, 34, 45, 45, 65, 76, 87, 99};
    int[] copia;
        
    System.out.print("\nBuble Sort... ");
    copia = original.clone();
    bubleSort(copia);
    System.out.println("Ok? " + iguais(copia, ordenado));
    
    System.out.print("\nInsertion Sort... ");
    copia = original.clone();
    insertionSort(copia);
    System.out.println("Ok? " + iguais(copia, ordenado));
  }
  
  public static void insertionSort(int v[]) {
    for (int i=1; i < v.length; i++) {
      int j = i;
      int t = v[j];
      
      while (j > 0 && v[j-1] > t) {
        v[j] = v[j-1];
        j--;
      }
      
      v[j] = t;
    }
  }
  
  public static void bubleSort(int v[]) {
    boolean trocou = true;
    
    while (trocou) {
      trocou = false;
      
      for (int i=0; i < v.length - 1; i++) {
        if (v[i] > v[i+1]) {
          int temp = v[i];
          v[i] = v[i+1];
          v[i+1] = temp;
          trocou = true;
        }
      }
    }
  }
  
  public static boolean iguais(int a[], int b[]) {
    boolean ok = true;
    
    for (int i=0; i < a.length; i++) {
      ok = ok && (a[i] == b[i]);
    }
    
    return ok;
  }
  
  public static void mostrar(int v[]) {
    for (int i: v) System.out.print(i + " ");
    System.out.println();
  }
}