package designPattern;

abstract class Robot {

	private String name;
	private MovingStrategy movingStrategy;
	private AttackStrategy attackStrategy;

	public Robot(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void move() {
		movingStrategy.move();
	}

	public void attack() {
		attackStrategy.attack();
	}

	public void setMovingStrategy(MovingStrategy movingStrategy) {
		this.movingStrategy = movingStrategy;
	}

	public void setAttackStrategy(AttackStrategy attackStrategy) {
		this.attackStrategy = attackStrategy;
	}
}

class Atom extends Robot {
	public Atom(String name) {
		super(name);
	}
}

interface MovingStrategy {
	public void move();
}

class FlyingStrategy implements MovingStrategy {
	public void move() {
		System.out.println("I can fly");
	}
}

class WalkingStrategy implements MovingStrategy {
	public void move() {
		System.out.println("I can only walk");
	}
}

interface AttackStrategy {
	public void attack();
}

class MissileStrategy implements AttackStrategy {
	public void attack() {
		System.out.println("I have Missile and can attack with it");
	}
}

class PunchStrategy implements AttackStrategy {
	public void attack() {
		System.out.println("I have strong punch and can attack with it");
	}
}

public class StrategySample2 {
	public static void main(String[] args) {
		Robot atom = new Atom("Atom");

		// �̵� ������ ���ư��ٴ� �������� ������
		atom.setMovingStrategy(new FlyingStrategy());
		// ���� ������ ��ġ�� �����ϴ� �������� ������
		atom.setAttackStrategy(new PunchStrategy());

		atom.move();
		atom.attack();
	}
}