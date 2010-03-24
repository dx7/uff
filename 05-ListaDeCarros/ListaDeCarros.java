class ListaDeCarros {
  Carro info;
  ListaDeCarros prox;
  
  public ListaDeCarros(Carro i) {
    info = i;
  }
  
  public ListaDeCarros(Carro i, ListaDeCarros l) {
    info = i;
    prox = l;
  }
  
  public String toString() {
    if (prox == null) return info + ".";
    return info + " -> " + prox;
  }
}