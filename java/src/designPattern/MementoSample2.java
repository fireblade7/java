package designPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Gamer의 상태를 나타내는 클래스 (Memento)
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

// 게임을 실행하는 주인공의 인스턴스, Memento의 인스턴스를 만든다
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

	// 스냅샷을 찍는다
	public Memento createMemento() {
		Memento m = new Memento(money);
		Iterator it = fruits.iterator();
		while (it.hasNext()) {
			String f = (String) it.next();
			m.addFruit(f);
		}
		return m;
	}

	// undo 실행
	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}
	// ...
}

// 사용 예
public class MementoSample2 {
	public static void main(String[] args) {
		Gamer2 gamer = new Gamer2(100);
		Memento memento = gamer.createMemento(); // 최초의 상태를 저장해 둔다
		// ...
		gamer.bet();
		// ...
		gamer.restoreMemento(memento); // undo 실행
	}
}