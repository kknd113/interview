public class myQueue {
	private List lst;

	public myQueue () {
		this.lst = new List();
	}

	public void push(int item) {
		this.lst.insertEnd(item);
	}

	public int pop() {
		return lst.removeFront();
	}

	public int peek() {
		return lst.head.item;
	}

	public int getSize() {
		return this.lst.getSize();
	}
	public myQueue copy() {
		myQueue copy = new myQueue();
		Node n = lst.head;
		for (int i=0; i < this.lst.getSize(); i++) {
			copy.push(n.item);
			n = n.next;
		}
		return copy;
	}
}