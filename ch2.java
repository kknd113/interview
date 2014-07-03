import java.util.*;
public class ch2{
  public static List createList(int[] arr) {
    List l = new List(arr[0]);
    for (int i=1; i < arr.length; i++) {
      l.insertEnd(arr[i]);
    }
    return l;
  }

  public static void printList(List l) {
    Node n = l.head;
    while (n != null) {
      System.out.print(n.item + " => ");
      n = n.next;
    }
    System.out.println("");
  }

  public static List removeDup(List l) {
    Node n = l.head;
    Hashtable<Integer,Boolean> table = new Hashtable<Integer,Boolean>();
    while (n.next != null) {
      if (table.get(n.item) != null) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
      } else {
        table.put(n.item, true);
      }
      n = n.next;
    }
    if (table.get(n.item) != null) {
      l.tail = n.prev;
      n.prev.next = null;
    }
    return l;
  }

  public static int kthLast(List l, int k) {
    int size = l.getSize();
    Node n = l.head;
    for (int i=0; i < size-k; i++) {
      n = n.next;
    }
    return n.item;
  }

  public static void deleteNode(Node n) {
    if (n.prev == null) {
      n.next.prev = null;
    }
    else if (n.next == null) {
      n.prev.next = null;
    }
    else {
      n.prev.next = n.next;
      n.next.prev = n.prev;
    }
  }

  public static List partitionList(List l, int i) {
    List left = new List();
    List right = new List();
    Node n = l.head;
    while (n != null) {
      if (n.item <= i) {
        left.insertEnd(n.item);
      } else {
        right.insertEnd(n.item);
      }
      n = n.next;
    }
    if (left.getSize() == 0) { return right; }
    else if (right.getSize() == 0) { return left; }
    else {
      left.tail.next = right.head;
      right.head.prev = left.tail;
      left.tail = right.tail;
      return left;
    }
  }

  public static int listToInt(List l, boolean rev) {
    int result = 0;
    if (rev) {
      int mul = 1;
      Node n = l.head;
      while (n != null) {
        result += (n.item * mul);
        mul *= 10;
        n = n.next;
      }
    } else {
      int mul = 1;
      Node n = l.tail;
      while (n != null) {
        result += (n.item * mul);
        mul *= 10;
        n = n.prev;
      }
    }
    return result;
  }

  public static List intToList(int i, boolean rev) {
    List result = new List();
    if (rev) {
      while (i > 0) {
        result.insertEnd(i%10);
        i /= 10;
      }
    } else {
      while (i > 0) {
        result.insertFront(i%10);
        i /= 10;
      }
    }
    return result;
  }

  public static List addList(List l1, List l2) {
    int x = listToInt(l1, false);
    int y = listToInt(l2, false);
    int sum = x + y;
    return intToList(sum,false);
  }

  public static int loopBegin(List l) {
    Node slow = l.head;
    Node fast = l.head;
    do {
      slow = slow.next;
      fast = fast.next.next;
    } while (slow.item != fast.item);

    slow = l.head;
    do {
      slow = slow.next.next;
      fast = fast.next.next;
    } while (slow.item != fast.item);

    return slow.item;
  }

  public static boolean isPalindrome(List l) throws Exception {
    Stack s = new Stack();
    int len = l.getSize();
    boolean isOdd = len %2 != 0;
    Node n = l.head;
    for (int i=0; i < len/2; i++) {
      s.push(n.item);
      n = n.next;
    }
    if (isOdd) {
      n = n.next;
    }
    while (n != null) {
      if (s.pop() != n.item) { return false; }
      n = n.next;
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    int[] arr = {1,2,2,1,2,3,3,2,1,3,2,1,1,1,2,3};
    List l = createList(arr);
    l = removeDup(l);
    printList(l);

    int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
    List l2 = createList(arr2);
    System.out.println(kthLast(l2,4));
    printList(l2);
    Node n = l2.head.next.next.next;
    deleteNode(n);
    printList(l2);

    int[] arr3 = {2,6,4,3,1,7,4,3,1,3,4,7,2};
    List inputL = createList(arr3);
    List outputL = new List();
    outputL = partitionList(inputL, 3);
    printList(outputL);

    int[] arr4 = {1,2,3,4,5};
    List l4 = createList(arr4);
    printList(l4);
    System.out.println(listToInt(l4,false));

    printList(intToList(12345, true));
    printList(intToList(12345, false));

    int[] arr5 = {6,1,7};
    List l5 = createList(arr5);

    int[] arr6 = {2,9,5};
    List l6 = createList(arr6);

    printList(addList(l5,l6));

    int[] arr7 = {1,2,3,4,5,6};
    List l7 = createList(arr7);
    Node nn = l7.head.next.next;
    l7.tail.next = nn;
    System.out.println(loopBegin(l7));

    int[] arr8 = {5,4,3,4,5,34};
    List l8 = createList(arr8);
    System.out.println(isPalindrome(l8));
  }
}
