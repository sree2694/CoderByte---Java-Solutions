import java.util.*; 
import java.io.*;

class Main {

  public static String MinWindowSubstring(String[] strArr) {
    // code goes here  
          String[] strLetters = strArr[0].split("(?<=[a-z])");
        String[] subLetters = strArr[1].split("(?<=[a-z])");
        Arrays.sort(subLetters);
        int minWindowLen = Integer.MAX_VALUE;
        String minWindowStr = "";
        for (int i = 0; i < strLetters.length - subLetters.length + 1; i++) {
            for (int j = i + subLetters.length - 1; j < strLetters.length; j++) {
                String[] testSubWindowLetters = Arrays.copyOfRange(strLetters, i, j + 1);
                String testSubWindow = Arrays.toString(testSubWindowLetters).replaceAll("[^a-z]", "");
                Arrays.sort(testSubWindowLetters);
                int k = 0;
                int m = 0;
                int count = 0;
                while (k < testSubWindowLetters.length && m < subLetters.length) {
                    if (testSubWindowLetters[k].charAt(0) == subLetters[m].charAt(0)) {
                        k++;
                        m++;
                        count++;
                    } else if (testSubWindowLetters[k].charAt(0) < subLetters[m].charAt(0)) {
                        k++;
                    } else {
                        m++;
                    }
                }
                if (count == subLetters.length) {
                    if (testSubWindow.length() < minWindowLen) {
                        minWindowLen = testSubWindow.length();
                        minWindowStr = testSubWindow;
                    }
                }
            }
        }
        return minWindowStr;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(MinWindowSubstring(s.nextLine())); 
  }

}