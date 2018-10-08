public class oneAway{
  public static void main(String[] args){
    System.out.println("test, tasu" + ":" + oneEditAway("test", "tasu"));
  }
  
  public static boolean oneEditAway(String s1, String s2){
    if(s1.equals(s2)){
      return true;
    }
    
    // if one character is wrong iterate over each character
    char[] s1Chars = s1.toCharArray();
    char[] s2Chars = s2.toCharArray();
    
    if(s1.length() == s2.length()){
      int wrongCharacters = 0;
      
      for(int x = 0; x<s1Chars.length; x++){
        if(s1Chars[x] != s2Chars[x])
        {
          wrongCharacters++;
        }
      }
      return wrongCharacters > 1
        ? false
        : true;
    }
    
// if one character is offset, offset the longer string once on a mismatch, return false on second failure.
    if(Math.abs(s1.length() - s2.length()) == 1){
      char[] largerString = null;
      char[] shorterString = null;
      
      if(s1.length() > s2.length()){
        largerString = s1Chars;
        shorterString = s2Chars;
      }else{
        largerString = s2Chars;
        shorterString = s1Chars;
      }
      
      boolean foundOffset = false;
      
      int shortCounter = 0;
      int longCounter = 0;
      for(int x = 0; x < shorterString.length; x++){
        if(largerString[longCounter] != shorterString[shortCounter]){
          if(foundOffset == true)
          {
            return false;
          }
          else
          {
            longCounter++;
            foundOffset = true;
          }
        }
        
        shortCounter++;
        longCounter++;
      }
      
      return true;
    }
    else{
      return false;
  }
  }
}