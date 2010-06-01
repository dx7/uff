/**
  Faça o procedimento que receba um parâmetro do tipo vet e produza um vetor do tipo ind que contém os índices para 
  elementos do vetor vet.	O ind[1] deve ser igual a i, onde i é o item de vet que possui o menor valor de chave. 
  O ind[2] deve ser igual a j, onde j é o item de vet que possui o segundo menor valor de chave. E assim sucessivamente. 
  Veja figuras no quadro negro.
*/
class Q1 {
  public static int[] procedimento (int[] v) {
    int[] ind = new int[v.length];
    int cloneOrdenado[] = ordenar(v.clone());
    
    for (int i = 0; i < cloneOrdenado.length; i++) {
      for (int j = 0; j < cloneOrdenado.length; j++) {
        if (cloneOrdenado[i] == v[j]) {
          ind[i] = j;
        }
      }
    }
    
    return ind;
  }
  
  // bubble sort
  public static int[] ordenar(int[] v) {
    boolean trocou = true;
    
    while (trocou) {
      trocou = false;
      
      for (int i = 0; i < v.length-1; i++) {
        if (v[i] > v[i+1]) {
          int temp = v[i];
          v[i] = v[i+1];
          v[i+1] = temp;
          trocou = true;
        }
      }
    }
    
    return v;
  }
  
  // métodos de teste
  
  public static void main(String[] args) {
    // testar ordenação
    System.out.print("Testando ordenação... ");
    int entrada1[] = { 4, 7, 1, 3 ,18, 12 };
    int saida1[] = { 1, 3, 4, 7, 12, 18 };
    System.out.println(testar(ordenar(entrada1), saida1));
    
    // testar o procedimento
    System.out.print("Testando o procedimento... ");
    int[] entrada = { 4, 7, 1, 3, 18, 12 };
    int[] saida = { 2, 3, 0, 1, 5, 4 };
    System.out.println(testar(procedimento(entrada), saida));
  }
  
  public static String testar(int[] a, int[] b) {
    if (a.length != b.length) return "FALHA: Tamanho recebido: " + a.length + " - Tamanho esperado: " + b.length;
    
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) return "FALHA: Vetores recebido é diferente do esperado";
    }
    
    return "SUCESSO!";
  }
}