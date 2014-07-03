public class ch3{

	public static void printStack(myStack s) {
		StringBuilder sb = new StringBuilder();
		myStack copy = s.copy();
		int i = copy.getSize();
		System.out.println(i);
		while (i > 0) {
			System.out.println(i);
			System.out.println(copy.peek());
			sb.insert(0, copy.pop() + ", ");
			i --;
		}
		System.out.println(sb);
	}

	public static void printQueue(myQueue s) {
		StringBuilder sb = new StringBuilder();
		myQueue copy = s.copy();
		int i = copy.getSize();
		System.out.println(i);
		while (i > 0) {
			System.out.println(i);
			System.out.println(copy.peek());
			sb.insert(0, copy.pop() + ", ");
			i --;
		}
		System.out.println(sb);
	}
	public static void main(String[] args) {
		myStack s = new myStack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(0);
		s.push(-324);
		System.out.println(s.peek());
		printStack(s);
		System.out.println("MIN = " + s.getMin());

		myQueue q = new myQueue();
		q.push(1);
		q.push(2);
		q.push(3);
		System.out.println(q.peek());
		printQueue(q);
	}
}