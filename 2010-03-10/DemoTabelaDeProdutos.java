import javax.swing.JOptionPane;

class DemoTabelaDeProdutos {
  public static void main(String[] args) {

    TabelaDeProdutos t = null;
    char op;
    
    do {
      op = menu();
      
      switch (op) {
        case 'm':
          if (t == null)
            JOptionPane.showMessageDialog(null, "Tabela ainda não criada.");
          else
            JOptionPane.showMessageDialog(null, t);
        break;
        
        case 'c':
          t = new TabelaDeProdutos(JOptionPane.showInputDialog("Nome"), Integer.parseInt(JOptionPane.showInputDialog("Capacidade")));
        break;
        
        case 'i':
          if (t == null)
            JOptionPane.showMessageDialog(null, "Tabela ainda não criada.");
          else {
            Produto p = new Produto(Integer.parseInt(JOptionPane.showInputDialog("Código")), JOptionPane.showInputDialog("Descrição"), Double.parseDouble(JOptionPane.showInputDialog("Quantidade")), Double.parseDouble(JOptionPane.showInputDialog("Preço")));

            if (t.inserir(p))
              JOptionPane.showMessageDialog(null, "Sucesso");
            else
              JOptionPane.showMessageDialog(null, "Não foi possível inserir.");
          }
        break; 
      }
    } while (op != 'x');
  }
  
  public static char menu() {
    String option = JOptionPane.showInputDialog("(i) Inserir\n (m) Mostrar\n (c) Construir\n (x) Terminar");
    
    return (option == null ? 'x' : option.charAt(0));
  }
}