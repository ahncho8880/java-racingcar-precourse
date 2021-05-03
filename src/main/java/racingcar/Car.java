package racingcar;

public class Car {
	private static final int MOVING_GAUGE = 4;
	public String name;
	public int position;

	public Car(String name) {
		this.name = name;
	}

	public void movePosition(int randomNumber) {
		if (randomNumber >= MOVING_GAUGE)
			position += 1;
	}

	public String getHyphen(int number) {
		StringBuilder hyphen = new StringBuilder();
		while (number-- > 0) {
			hyphen.append("-");
		}
		return hyphen.toString();
	}

	public String toStringCar() {
		return name + " : " + getHyphen(position);
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}