package designPattern;

//기능의 클래스 ('표시한다'는 클래스)
class Display {
	private DisplayImpl impl;

	public Display(DisplayImpl impl) {
		this.impl = impl;
	}

	public void open() {
		impl.rawOpen();
	}

	public void print() {
		impl.rawPrint();
	}

	public void close() {
		impl.rawClose();
	}

	public final void display() {
		open();
		print();
		close();
	}
}

// 기능의 클래스 ('지정 횟수만큼 표시한다'는 기능을 추가하는 클래스)
class CountDisplay extends Display {
	public CountDisplay(DisplayImpl impl) {
		super(impl);
	}

	public void multiDisplay(int times) {
		open();
		for (int i = 0; i < times; i++) {
			print();
		}
		close();
	}
}

// 구현의 클래스 ('표시한다'는 클래스)
abstract class DisplayImpl {
	public abstract void rawOpen();

	public abstract void rawPrint();

	public abstract void rawClose();
}

// 구현의 클래스 ('문자열을 사용해서 표시한다'는 클래스)
class StringDisplayImpl extends DisplayImpl {
	private String string;
	private int width;

	public StringDisplayImpl(String string) {
		this.string = string;
		this.width = string.getBytes().length;
	}

	public void rawOpen() {
		// ...
	}

	public void rawPrint() {
		// ...
	}

	public void rawClose() {
		// ...
	}
}

// 사용 예
public class BridgeSample2 {
	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImpl("Hello, Korea"));
		CountDisplay d2 = new CountDisplay(new StringDisplayImpl("Hello, Universe"));

		d1.display();
		d2.display();
		d2.multiDisplay(5);
	}

}