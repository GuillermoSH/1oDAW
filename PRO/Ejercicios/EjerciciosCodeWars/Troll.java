public class Troll {
    public static String disemvowel(String str) {
      String disemvowel = "";  
      String letter;
      
      for ( int index = 0; index < str.length(); index ++) {
        letter = str.substring(index, index + 1);
        
        switch ( letter ){
            case "a": case "A": case "e": case "E": case "i": case "I": case "o": case "O": case "u": case "U":
                disemvowel += "";
                break;
            default:
                disemvowel += letter;
        }
      }
      return disemvowel;
    }
}