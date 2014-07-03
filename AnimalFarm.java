import java.util.*;

public class AnimalFarm {
	Queue<Animal> farm;
	Queue<Dog> dogQueue;
	Queue<Cat> catQueue;
	int timer = 0;
	public AnimalFarm() {
		this.farm = new LinkedList<Animal>();
		this.dogQueue = new LinkedList<Dog>();
		this.catQueue = new LinkedList<Cat>();
	}

	public void enqueue(Animal a) {
		a.time = timer;
		if (a instanceof Cat) {
			this.catQueue.offer((Cat)a);
		} else {
			this.dogQueue.offer((Dog)a);
		}
		timer++;
	}

	public Animal dequeueDog() {
		return this.dogQueue.poll();
	}

	public Animal dequeueCat() {
		return this.catQueue.poll();
	}

	public Animal dequeueAny() {
		Cat c = (Cat)catQueue.peek();
		Dog d = (Dog)dogQueue.peek();
		if (c == null || c.time < d.time) { return c; }
		else { return d; }
	}
}