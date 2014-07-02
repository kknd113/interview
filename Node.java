public class Node {
  protected int item;
  protected Node prev;
  protected Node next;

  Node(int item) {
    this.item = item;
    this.prev = null;
    this.next = null;
  }

  Node(int item, Node prev, Node next) {
    this.item = item;
    this.prev = prev;
    this.next = next;
  }

  public Node next() {
    return this.next;
  }

  public Node prev() {
    return this.prev;
  }
}
