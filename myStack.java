import java.util.*;

public class myStack {
	private List lst;
	private List minLst;
	myStack () {
		this.lst = new List();
		this.minLst = new List();
	}

	public int pop() {
		int removed = lst.removeEnd();
		if (removed == this.minLst.tail.item) {
			this.minLst.removeEnd();
		}
		return removed;
	}

	public void push(int item) {
		if (getSize() == 0 || item <= this.minLst.tail.item) {
			this.minLst.insertEnd(item);
		}
		this.lst.insertEnd(item);
	}
	public int getMin() {
		return this.minLst.tail.item;
	}
	public int getSize() {
		return this.lst.getSize();
	}

	public int peek() {
		return lst.tail.item;
	}
	public myStack copy() {
		myStack copy = new myStack();
		Node n = lst.head;
		for (int i=0; i < this.lst.getSize(); i++) {
			copy.push(n.item);
			n = n.next;
		}
		return copy;
	}
}