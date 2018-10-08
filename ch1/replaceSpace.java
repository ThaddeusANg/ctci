import java.util.stream.*;

public class replaceSpace{
  public static void main(String[] args){
    replaceSpace main = new replaceSpace();
    System.out.println(main.formattedString("test test2"));
    System.out.println(main.formattedString(" test test2 "));
    System.out.println(main.formattedString("  "));
  }
  
  public String formattedString(String text){
    return text.chars().mapToObj(c-> {
      char currentC = (char) c;
      return currentC == ' '
        ? "%20"
        : currentC+"";
    }).collect(Collectors.joining(""));
  }
}