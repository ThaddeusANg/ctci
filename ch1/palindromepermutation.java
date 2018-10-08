import java.util.*;
import java.util.stream.Collectors;

public class palindromepermutation{
  public static void main(String [] args){
    List<String> test = Arrays.asList("a", "a ", "aba", "taco cat", "ab", "abcc", "a  ");
    for(String testCase: test){
      System.out.println(testCase+ ": " + isPalindromePermutation(testCase));
    }
  }
  
  public static boolean isPalindromePermutation(String text){
        Map<Character, Long> map = text.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    
    if(text.length()%2 == 0){
      // if no spaces, all characters must be paired
      if(map.containsKey(' ') == false){
        if(map.entrySet()
             .stream()
             .filter(c -> (long)c.getValue() == 1)
             .count() == 0)
        {
        return true;
        }
        else{
          return false;
        }
      }
      else if(map.get(' ')%2 == 1)
      {
        boolean foundCharacterWithOddCount = false;
        // if there are an odd number of spaces, there can be one unpaired character
        for(Map.Entry entry : map.entrySet()){
          if((char)entry.getKey() != ' ' && (long)entry.getValue()%2 == 1){

            if(foundCharacterWithOddCount == false){
            foundCharacterWithOddCount = true;
            }
            else{
              // cannot have more than 1 unmatched character
              return false;
            }
          }
        }
        
        return true;
      }
    }
    else{
      // if there is one unpaired character space or otherwise
      for(Map.Entry entry : map.entrySet()){
          if((long)entry.getValue()%2 == 1){
          return true;}
        }
        
        return false;
    }
    return false;
  }
}