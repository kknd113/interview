import java.util.*;

public class ch1 {

  public static boolean isUnique(String str) {
    char[] arr = str.toCharArray();
    Hashtable<Character,Boolean> table = new Hashtable<Character,Boolean>();
    for (char ch : arr) {
      if (table.get(ch) != null) { return false; }
      else { table.put(ch,true); }
    }
    return true;
  }


  public static boolean isUniqueFast(String str) {
    int[] arr = new int[256];
    char[] charArr = str.toCharArray();
    for (char c : charArr) {
      if (arr[c] == 1) { return false; }
      else { arr[c] = 1; }
    }
    return true;
  }

  public static String rever(String str) {
    char[] charArr = str.toCharArray();
    int len = charArr.length;
    char[] result = new char[len];
    for (int i=0; i < len; i++) {
      result[i] = charArr[len-i-1];
    }
    return new String(result);
  }

  public static boolean isPerm(String str1, String str2) {
    char[] arr1 = str1.toCharArray();
    char[] arr2 = str2.toCharArray();
    if (arr1.length != arr2.length) { return false; }
    int[] arr = new int[256];
    for (int i=0; i < arr1.length; i++) {
      arr[arr1[i]] += 1;
      arr[arr2[i]] -= 1;
    }

    for (int i=0; i < arr.length; i++) {
      if (arr[i] != 0) { return false; }
    }
    return true;
  }

  public static String replaceWhiteSpace(String str, int trueLen) {
    char[] arr = str.toCharArray();
    char[] result = new char[arr.length];
    int len = arr.length;
    for(int i=trueLen-1; i >=0; i--) {
      if (arr[i] == ' ') {
        result[--len] = '0';
        result[--len] = '2';
        result[--len] = '%';
      } else {
        result[--len] = arr[i];
      }
    }
    return new String(result);
  }

  public static String compressString(String str) {
    StringBuilder result = new StringBuilder();
    char[] arr = str.toCharArray();
    char current = arr[0];
    int count = 1;
    for (int i=1; i < arr.length; i++) {
      if (arr[i] == current) { count++; }
      else {
        result.append(current);
        result.append(count);
        current = arr[i];
        count = 1;
      }
    }
    result.append(current);
    result.append(count);
    return result.toString();
  }

  public static boolean isSubstring(String str1, String str2) {
    char[] arr1 = str1.toCharArray();
    char[] arr2 = str2.toCharArray();
    for (int i=0; i < arr1.length - arr2.length+1; i++) {
      if ((arr1[i] == arr2[0]) && str1.substring(i, i+arr2.length).equals(new String(arr2))) {
          return true;
      }
    }
    return false;
  }

  public static boolean isRotation(String str1, String str2) {
    if (str1.length() != str2.length()) { return false; }
    return isSubstring(str1+str1, str2);
  }




  /* TODO: Write an algo. such that if an elem in an MxN matrix is 0, its entire row and col
           are set to 0
  */


  /* TODO: Given an image represented by an NxN mat, where each pixel in the image is 4 bytes,
           write a method to rotate the image by 90 degress.
           Can you do this in plcae?
  */

  
  public static void main (String[] args) {
    String s = "reverse this";
    System.out.println(isUniqueFast(s));
    System.out.println(rever(s));
    System.out.println(isPerm("abcdee", "debca"));
    System.out.println(replaceWhiteSpace("Mr John Smith    ", 13));
    System.out.println(compressString("aaabbccddeeee"));
    System.out.println(isSubstring("wefcccchriislfwek", "chris"));
    System.out.println(isRotation("chriskim", "imchrisk"));
  }
}
