class Produto {
  int codigo;
  String descricao;
  double preco, qtd;
  
  public Produto(int c, String d, double p, double q) {
    codigo = c;
    descricao = d;
    qtd = q;
    preco = p;
  }
  
  public Produto() {
    codigo = 0;
    descricao = "";
    qtd = preco = 0;
  }
  
  public String toString() {
    return codigo + " " + descricao + " " + qtd + " " + preco;
  }
}