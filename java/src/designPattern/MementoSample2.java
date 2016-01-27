package designPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Gamer�� ���¸� ��Ÿ���� Ŭ���� (Memento)
class Memento {
	int money;
	ArrayList fruits;

	public int getMoney() {
		return money;
	}

	Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList<>();
	}

	void addFruit(String fruit) {
		fruits.add(fruit);
	}

	List getFruits() {
		return (List) fruits.clone();
	}
}

// ������ �����ϴ� ���ΰ��� �ν��Ͻ�, Memento�� �ν��Ͻ��� �����
class Gamer2 {
	private int money;
	private List fruits = new ArrayList();

	// ...
	public Gamer2(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void bet() {
		// ...
	}

	// �������� ��´�
	public Memento createMemento() {
		Memento m = new Memento(money);
		Iterator it = fruits.iterator();
		while (it.hasNext()) {
			String f = (String) it.next();
			m.addFruit(f);
		}
		return m;
	}

	// undo ����
	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}
	// ...
}

// ��� ��
public class MementoSample2 {
	public static void main(String[] args) {
		Gamer2 gamer = new Gamer2(100);
		Memento memento = gamer.createMemento(); // ������ ���¸� ������ �д�
		// ...
		gamer.bet();
		// ...
		gamer.restoreMemento(memento); // undo ����
	}
}