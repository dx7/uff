class Palindrome {
  public static void main(String[] args) {
    // palindrome("wow");
    // palindrome("wowwow");
    // palindrome("wwwwwooooo");
    // palindrome("sfsdnjhkhlh");
    // palindrome("woww");
    // palindrome("ababa");
    
    System.out.println(palindromeRecursivo("wow"));
    System.out.println(palindromeRecursivo("wowwow"));
    System.out.println(palindromeRecursivo("wwwwwooooo"));
    System.out.println(palindromeRecursivo("sfsdnjhkhlh"));
    System.out.println(palindromeRecursivo("woww"));
    System.out.println(palindromeRecursivo("ababa"));
    
    substrings("abacaxi");
  }
  
  public static void substrings(String p) {
    for (int i = 0; i <= p.length(); i++) {
      for (int j = i + 3; j <= p.length(); j++) {
        if (palindromeRecursivo(p.substring(i, j))) {
          System.out.println(p.substring(i, j));
        }
      }
    }
  }
  
  public static void palindrome(String palavra) {
    System.out.println("\nAnalisando: " + palavra);
    
    for (int i=0; i < palavra.length()/2; i++) {
      System.out.println(palavra.charAt(i) + " == " + palavra.charAt(palavra.length()-(i+1)) + "? " + !(palavra.charAt(i) != palavra.charAt(palavra.length()-(i+1))));
      
      if (palavra.charAt(i) != palavra.charAt(palavra.length()-(i+1))) {
        System.out.println("Não é palíndrome!");
        return;
      }
    }
    
    System.out.println("É palíndrome!");
  }
  
  public static boolean palindromeRecursivo(String palavra) {
    if (palavra.length() < 2) return true;
    if (palavra.charAt(0) != palavra.charAt(palavra.length()-1)) return false;
    
    return true && palindromeRecursivo(palavra.substring(1, palavra.length()-1));
  }
}