public class List {
  protected Node head = null;
  protected Node tail = null;

  List () {
    this.head = null;
    this.tail = null;
  }

  List(int item) {
    this.head = new Node(item);
    this.tail = this.head;
  }

  public void insertFront(int item) {
    if (this.head == null) {
      Node n = new Node(item);
      this.head = n;
      this.tail = head;
    } else {
      Node n = new Node(item);
      head.prev = n;
      n.next = head;
      this.head = n;
    }
  }

  public void insertEnd(int item) {
    if (this.head == null) {
      Node n = new Node(item);
      this.head = n;
      this.tail = head;
    } else {
      Node n = new Node(item);
      tail.next = n;
      n.prev = tail;
      this.tail = n;
    }
  }

  public int getSize() {
    Node n = this.head;
    int size = 0;
    while (n != null) {
      size++;
      n = n.next;
    }
    return size;
  }

  public int removeEnd() {
    Node n = null;
    n = this.tail;
    this.tail = this.tail.prev;
    if (this.tail != null) {
      this.tail.next = null;
    }
    return n.item;
  }

  public int removeFront() {
    Node n = null;
      n = this.head;
      this.head = this.head.next;
      if (this.head != null) {
        this.head.prev = null;
      }
    return n.item;
  }
}
