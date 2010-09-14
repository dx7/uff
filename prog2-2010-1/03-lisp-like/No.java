class No {
  int info;
  No proximo;
  
  public No(int i) {
    info = i;
    proximo = null;
  }
  
  public String toString() {
    if (proximo == null) return String.valueOf(info);
    return info + " -> " + proximo;
  }
}