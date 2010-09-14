class PilhaDemo {
  public static void main(String[] args) {
    Pilha p = new Pilha();
    
    p.empilha(11);
    p.empilha(26);
    p.empilha(59);
    p.empilha(100);
    
    p.mostrar();
    p.mostrar();
    p.mostrar();
  }
}

class Pilha {
	private No topo;
	private int total;
	
	public Pilha() {
	  total = 0;
	}
	
	public void mostrar() {
  	No temp = topo;
	
  	while(temp != null) {
  	  System.out.println(temp.info);
  	  temp = temp.prox;
  	}
	}
	
	public void empilha(Object novo) {
	  try {
	    No temp = new No(novo);
	    temp.prox = topo;
	    topo = temp;
	    total++;
	  } catch (Exception e) {
	    e.printStackTrace();
	  }
	}
	
	public boolean desempilha() {
	  if (total == 0) return false;
	  
    topo = topo.prox;
    total--;
    return true;
	}
	
	public Object topo() {
	 if (total == 0) return null;
	 
   return topo.info;
	}
	
	public int tamanho() {
	 return total;
	}
	
	public boolean vazia() {
	 return total == 0;
	}
}