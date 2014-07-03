import java.util.*;
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

	public static Stack sortStack(Stack s) {
		Stack<Integer> original =(Stack<Integer>) s.clone();
		Stack<Integer> copy = new Stack<Integer>();
		copy.push(original.pop());
		while (original.size() > 0) {
			int i = original.pop();
			int counter = 0;
			while (copy.size() > 0 && i < copy.peek()) {
				counter ++;
				original.push(copy.pop());
			}
			copy.push(i);
			while (counter > 0) {
				copy.push(original.pop());
				counter --;
			}
		}
		return copy;
	}

	public static void main(String[] args) throws Exception{
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

		Sstack sss = new Sstack(3);
		sss.push(1);
		sss.push(2);
		sss.push(3);
		sss.push(4);
		System.out.println("\n\n\n\n");
		System.out.println(sss.pop());
		System.out.println(sss.pop());
		System.out.println(sss.pop());
		System.out.println(sss.pop());

		System.out.println("\n\n\n\n");
		Qqueue qq = new Qqueue();
		qq.push(1);
		qq.push(2);
		qq.push(3);
		qq.push(4);
		qq.push(5);
		System.out.println(qq.pop());
		System.out.println(qq.pop());
		System.out.println(qq.pop());
		qq.push(23);
		qq.push(234);
		System.out.println(qq.pop());
		System.out.println(qq.pop());
		System.out.println(qq.pop());
		System.out.println(qq.pop());

		Stack<Integer> st = new Stack<Integer>();
		st.push(3);
		st.push(4);
		st.push(2);
		st.push(5);
		st.push(523);
		st.push(1);
		st = sortStack(st);
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());



		System.out.println("\n\n\n\n");
		Dog d1 = new Dog("d1",0);
		Dog d2 = new Dog("d2",0);
		Dog d3 = new Dog("d3",0);
		Dog d4 = new Dog("d4",0);
		Cat c1 = new Cat("c1",0);
		Cat c2 = new Cat("c2",0);
		Cat c3 = new Cat("c3",0);
		Cat c4 = new Cat("c4",0);
		AnimalFarm af = new AnimalFarm();
		af.enqueue(c1);
		af.enqueue(d4);
		af.enqueue(c3);
		af.enqueue(c2);
		af.enqueue(d3);
		af.enqueue(d2);
		af.enqueue(c4);
		af.enqueue(d1);
		System.out.println(af.dequeueDog().name);
		System.out.println(af.dequeueAny().name);


	}
}