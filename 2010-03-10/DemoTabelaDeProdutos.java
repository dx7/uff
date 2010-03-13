import javax.swing.JOptionPane;

class DemoTabelaDeProdutos {
  public static void main(String[] args) {

    /*
     * Em Java, toda variável local, primitiva ou não, deve ser inicializada com algum valor antes de ser usada.
     * Isso é obrigatório! Logo, sem esse null abaixo, não funciona.
     */
    TabelaDeProdutos t = null;
    
    /*
     * Agora não é necessário inicializar a variável, pois isso será feito abaixo, quando fazemos op = menu().
     */
    char op;
    
    do {
      op = menu();
      
      switch (op) {
        case 'm':
          if (t == null) // Aqui usamos a variável t, por isso ela precisou ser inicializada acima com null.
            JOptionPane.showMessageDialog(null, "Tabela ainda não criada.");
          else
            JOptionPane.showMessageDialog(null, t);
        break;
        
        case 'c':
          /*
           * O JOptionPane retorna o que o usuário digita como um objeto String. Mas não é tão simples assim.
           * Caso o usuário clique em "Cancelar", será retornado um null. E se vc não tratou isso, vc poderá ter um
           * belo "NullPointerException".
           *
           * Geralmente também é necessário tratar se o usuário não digitou nada e clicou em "Ok" ou deu "Enter".
           * Isso irá retornar uma String vazia.
           *
           * Pra tratar isso, primeiro armazena-se o que chegar - seja lá o que for - do JOptionPane, como abaixo:
           */
          String nome = JOptionPane.showInputDialog("Nome");
          String capacidade = JOptionPane.showInputDialog("Capacidade");
          
          /*
           * Antes de fazer qualquer coisa, verifica-se se o conteúdo retornado é null ou vazio.
           * E só depois da verificação e tratamento, usa-se o resultado.
           */
          if (nome == null) nome = "Sem nome";
          if (capacidade == null || capacidade.isEmpty()) capacidade = "0";
          
          t = new TabelaDeProdutos(nome, Integer.parseInt(capacidade));
        break;
        
        case 'i':
          if (t == null) {
            JOptionPane.showMessageDialog(null, "Tabela ainda não criada.");
          } else {
            String codigo = JOptionPane.showInputDialog("Código");
            
            if(codigo == null || codigo.isEmpty()) {
              JOptionPane.showMessageDialog(null, "O código informado é inválido.");
            } else {
              String descricao = JOptionPane.showInputDialog("Descrição");
              if (descricao == null) descricao = "";
              
              String qtd = JOptionPane.showInputDialog("Quantidade");
              if (qtd == null || qtd.isEmpty()) qtd = "0";
              
              String preco = JOptionPane.showInputDialog("Preço");
              if (preco == null || preco.isEmpty()) preco = "0";
              
              Produto p = new Produto(Integer.parseInt(codigo), descricao, Double.parseDouble(qtd), Double.parseDouble(preco));

              if (t.inserir(p))
                JOptionPane.showMessageDialog(null, "Sucesso");
              else
                JOptionPane.showMessageDialog(null, "Não foi possível inserir.");
            }
          }
        break; 
      }
    } while (op != 'x');
  }
  
  public static char menu() {
    String option = JOptionPane.showInputDialog("(i) Inserir\n (m) Mostrar\n (c) Construir\n (x) Terminar");
    return (option == null || option.isEmpty() ? 'x' : option.charAt(0));
  }
}