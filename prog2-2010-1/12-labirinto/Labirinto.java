class Labirinto {
  public static char[][] lab = {{' ', '*', ' ', ' ', '*', ' ', ' ', ' '}, 
                            {' ', '*', ' ', ' ', '*', ' ', ' ', '*'}, 
                            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
                            {' ', '*', '*', '*', '*', ' ', '*', '*'}, 
                            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
                            {' ', '*', '*', '*', '*', '*', '*', '*'}, 
                            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
                           };
                           
  public static void main(String[] args) {
    apresentar();
    encontrar(0, 0, 6, 7);
  }
  
  public static void encontrar(int xo, int yo, int xd, int yd) {
    lab[xo][yo] = '•';
    apresentar();
    
    if (xo == xd && yo == yd) {
      System.out.println("########## Completo ##########");
      apresentar();
      return;
    } else {
      for (int x = xo-1; x <= xo+1 ; x++) {
        for (int y = yo-1; y <= yo+1; y++) {
          if ((x >= 0) && (x < lab.length) && (y >= 0) && (y < lab[0].length) && (lab[x][y] == ' ')) {
            encontrar(x, y, xd, yd);
          }
        }
      }
    }
    
    lab[xo][yo] = ' ';
  }
  
  public static void apresentar() {
    System.out.println("\nLabirinto:");
    for (int i=0; i<lab.length; i++) {
      for (int j=0; j<lab[i].length; j++) {
        System.out.print("|" + lab[i][j]);
      }
      System.out.println("|");
    }
  }
}