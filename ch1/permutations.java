import java.util.*;

public class permutations{
  public static void main(String[] args){
    permutations perm = new permutations();
    System.out.println(perm.IsAPermutation("test", "test"));
  }
  
  public boolean IsAPermutation(String textA, String textB){
    
    if(textA.length() != textB.length()){
      return false;
    }
    
    HashMap<Character,Integer> characterMap = new HashMap<Character,Integer>();
    HashMap<Character,Integer> characterMapB = new HashMap<Character,Integer>();
    
    for(int x = 0; x < textA.length(); x++){
      Character c = textA.charAt(x);
      if(characterMap.get(c) == null)
      {
        characterMap.put(c, 1);
      }
      else{
        characterMap.put(c, characterMap.get(c)+1);
      }
    }
    
    for(int x = 0; x< textB.length(); x++){
      Character c = textB.charAt(x);
      if(characterMapB.get(c) == null){
        characterMapB.put(c, 1);
      }
      else{
        characterMapB.put(c, characterMapB.get(c) + 1);
      }
    }
    
    for(Map.Entry<Character,Integer> kvp: characterMap.entrySet()){
      Character key = kvp.getKey();
      Integer value = kvp.getValue();
      Integer comparisonValue = characterMapB.get(key);
      if(value != comparisonValue){
        return false;
      }
    }
    
    return true;
  }
}