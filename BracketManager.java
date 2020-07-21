import java.util.*; 
import java.io.*;

class Main {

  public static String BracketMatcher(String str) {
    // code goes here  
          Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.size() == 0) {
                    return "0";
                }
                stack.pop();
            }
        }
        return (stack.size() == 0 ? "1" : "0");
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(BracketMatcher(s.nextLine())); 
  }

}