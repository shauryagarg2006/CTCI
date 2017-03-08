package ctci.prac.stacks;

import java.util.ArrayList;
import java.util.List;

abstract class Animal {
	String name;

	public Animal(String input) {
		name = input;
	}

	public String getName() {
		return name;
	}

}

class Cats extends Animal {
	public Cats(String input) {
		super(input);
	}
}

class Dogs extends Animal {
	public Dogs(String input) {
		super(input);
	}
}

public class AnimalShelter {
	Queue<Cats> cats;
	Queue<Dogs> dogs;
	List<Animal> order;

	public AnimalShelter() {
		cats = new Queue<Cats>();
		dogs = new Queue<Dogs>();
		order = new ArrayList<Animal>();
	}

	public String dequeueAny() {
		if (order.isEmpty()) {
			throw new NullPointerException();
		}
		Animal temp = order.get(0);
		order.remove(0);
		if (temp instanceof Cats) {
			cats.dequeue();
		} else {
			dogs.dequeue();
		}
		return temp.getName();
	}

	public void enqueueCat(String inputs) {
		Cats temp = new Cats(inputs);
		cats.enqueue(temp);
		order.add(temp);

	}

	public void enqueueDogs(String inputs) {
		Dogs temp = new Dogs(inputs);
		dogs.enqueue(temp);
		order.add(temp);

	}

	public String dequeueCats() {
		if (cats.isEmpty()) {
			return cats.dequeue().getName();
		} else {
			Cats temp = cats.dequeue();
			order.remove(temp);
			return temp.getName();
		}
	}

	public String dequeueDogs() {
		if (dogs.isEmpty()) {
			return dogs.dequeue().getName();
		} else {
			Dogs temp = dogs.dequeue();
			order.remove(temp);
			return temp.getName();
		}
	}
}
