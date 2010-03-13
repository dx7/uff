import javax.swing.JOptionPane;

class TorreDeHanoi {
  public static String hanoi(int num, String o, String a, String d) {
    if (num <= 0) return "";
    return hanoi(num-1, o, d, a) + o + " -> " + d + "\n" + hanoi(num-1, a, o, d);
  }
  
  public static void main(String[] args) {
    String option = JOptionPane.showInputDialog("Número do disco");
    int num = (option != null && !option.isEmpty()) ? Integer.parseInt(option) : -1;
    
    while (num >= 0) {
      System.out.println(hanoi(num, "origem", "auxiliar", "destino"));
      option = JOptionPane.showInputDialog("Número do disco");
      num = (option != null && !option.isEmpty()) ? Integer.parseInt(option) : -1;
    }
  }
}