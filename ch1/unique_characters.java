import java.util.*;

public class unique_characters{
  public static void main(String[] args){
    String allUnique = "ABCDE";
    String someDuplicates = "ABCDDE";
    
    System.out.println(allUnique+ " : " + allUniqueCharactersNoStructures(allUnique));
    System.out.println(someDuplicates+ " : " + allUniqueCharactersNoStructures(someDuplicates));
  }
  
  public static boolean allUniqueCharacters(String text){
    HashMap<Character, Integer> letterMap = new HashMap<Character, Integer>();
    
    for(int x = 0; x< text.length(); x++){
      Character c = text.charAt(x);

      if(letterMap.containsKey(c) == false){
        letterMap.put(c, 1);
      }
      else{
        letterMap.put(c, letterMap.get(c)+1);
      }
    }
    
    for(Map.Entry kvp : letterMap.entrySet()){
      Integer value = (Integer) kvp.getValue();
      
      if( value > 1){
        return false;
      }
    }
    
    return true;
  }
  
  public static boolean allUniqueCharactersNoStructures(String text){
    if(text.length() == 1){
      return true;
    }
    else{
      Character c = text.charAt(0);
      String substring = text.substring(1);
      
      if(substring.contains(c+"")){
        return false;
      }else{
        return allUniqueCharactersNoStructures(substring);
      }
    }
  }
}