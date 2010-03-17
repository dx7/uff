import javax.swing.JOptionPane;

class Fatorial {
  public static int calc(int num) {
    if (num <= 1) return 1;
    return num * calc(num-1);
  }
  
  public static void main(String[] args) {
    String option = JOptionPane.showInputDialog("Número");
    int num = (option != null && !option.isEmpty()) ? Integer.parseInt(option) : -1;
    
    while (num >= 0) {
      System.out.println(calc(num));
      
      option = JOptionPane.showInputDialog("Número");
      num = (option != null && !option.isEmpty()) ? Integer.parseInt(option) : -1;
    }
  }
}