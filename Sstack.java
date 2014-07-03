import java.util.*;

public class Sstack {
	int stackSize;
	ArrayList<Stack> sArr;
	int size;
	Sstack (int size) {
		this.size = 0;
		this.stackSize = size;
		this.sArr = new ArrayList<Stack>();
	}

	public void push(int item) {
		if (this.size == 0 || (this.size % stackSize) == 0) {
			System.out.println("another stack..." + " for " + item);
			Stack<Integer> s = new Stack<Integer>();
			s.push(item);
			this.size++;
			sArr.add(s);
		} else {
			Stack<Integer> ss = sArr.get((this.size / stackSize));
			ss.push(item);
			this.size++;
		}
	}

	public int pop() throws Exception {
		Stack<Integer> s = this.sArr.get((this.size-1) / stackSize);
		this.size--;
		return s.pop();
	}
}