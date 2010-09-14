class TabelaDeProdutos {
  int usados;
  Produto[] tab;
  String nome;
  
  public TabelaDeProdutos() {
    tab = new Produto[10];
    nome = "Anônimo";
    usados = 0;
  }
  
  public String toString() {
    String resp = nome + "\n";
    
    for (int i = 0; i < usados; i++) {
      resp = resp + tab[i] + "\n";
    }
    
    return resp;
  }
  
  public TabelaDeProdutos(String n, int capacidade) {
    tab = new Produto[capacidade];
    nome = n;
    usados = 0;
  }
  
  public boolean inserir(Produto p) {
    if (usados >= tab.length) {
      return false;
    }
    
    tab[usados] = p;
    usados++;
    return true;
  }
}