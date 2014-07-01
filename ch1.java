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
  
  public static void main (String[] args) {
    String s = "reverse this";
    System.out.println(isUniqueFast(s));
    System.out.println(rever(s));
    System.out.println(isPerm("abcdee", "debca"));
  }
}
