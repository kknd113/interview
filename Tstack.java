public class Tstack {
	int stackSize;
	int[] buffer;
	int[] stackPointer = {-1, -1, -1};

	Tstack() {
		this.stackSize = 100;
		this.buffer = new int[ 3 * stackSize];
	}

	public void push(int stackNum, int value) {
		if (stackPointer[stackNum] + 1 >= stackSize) {
			System.out.println("Stack size exceeded");
		} else {
			stackPointer[stackNum]++;
			buffer[stackPointer[stackNum] + stackNum*100] = value;
		}
	}

	public int pop(int stackNum) {
		if (stackPointer[stackNum] < 0) {
			System.out.println("Stack Empty!!!");
			return -10;
		} else {
			int value = 0;
			value = buffer[stackPointer[stackNum] + stackNum*100];
			buffer[stackPointer[stackNum] + stackNum*100] = 0;
			stackPointer[stackNum]--;
			return value;
		}
	}

	public int peek(int stackNum) {
		if (stackPointer[stackNum] < 0) {
			System.out.println("Stack Empty!!!");
			return -10;
		} else {
			int value = 0;
			value = buffer[stackPointer[stackNum] + stackNum*100];
			return value;
		}
	}
}