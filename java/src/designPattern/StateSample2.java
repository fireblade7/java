package designPattern;

interface State {
	public void on_button_pushed(StateSample2 light);

	public void off_button_pushed(StateSample2 light);
}

class ON implements State {
	public void on_button_pushed(StateSample2 light) {
		System.out.println("반응 없음");
	}

	public void off_button_pushed(StateSample2 light) {
		System.out.println("Light Off!");
		light.setState(new OFF());
	}
}

class OFF implements State {
	public void on_button_pushed(StateSample2 light) {
		System.out.println("Light On!");
		light.setState(new ON());
	}

	public void off_button_pushed(StateSample2 light) {
		System.out.println("반응 없음");
	}
}

public class StateSample2 {
	private State state;

	public StateSample2() {
		state = new OFF();
	}

	public void setState(State state) {
		this.state = state;
	}

	public void on_button_pushed() {
		state.on_button_pushed(this);
	}

	public void off_button_pushed() {
		state.off_button_pushed(this);
	}
}
