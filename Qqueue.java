import java.util.*;

public class Qqueue {
	Stack<Integer> s1;
	Stack<Integer> s2;
	int size;

	Qqueue() {
		this.s1 = new Stack<Integer>();
		this.s2 = new Stack<Integer>();
		this.size = 0;
	}

	public void push(int item) {
		this.s1.push(item);
		this.size++;
	}

	public int pop() {
		if (s2.size() <= 0) {
			while ( !s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		this.size--;
		return s2.pop();
	}

	public boolean isEmpty() {
		return this.size <= 0;
	}

	public int peek() {
		if (s2.size() <= 0) {
			while ( !s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		this.size--;
		return s2.peek();
	}
}