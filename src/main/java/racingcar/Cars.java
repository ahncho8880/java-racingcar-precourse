package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
	private static final int RANDOM_BOUND = 10;
	private final Random random = new Random();
	private final List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public void moveCarsPosition() {
		for (Car car : cars) {
			int randomNumber = random.nextInt(RANDOM_BOUND);
			car.movePosition(randomNumber);
		}
	}

	public int getFirstPosition() {
		int firstPosition = 0;
		for (Car car : cars) {
			firstPosition = Math.max(car.getPosition(), firstPosition);
		}
		return firstPosition;
	}

	public List<String> getWinners() {
		List<String> winners = new ArrayList<>();
		for (Car car : getCars()) {
			addWinner(winners, car);
		}
		return winners;
	}

	public void addWinner(List<String> winners, Car car) {
		if (getFirstPosition() == car.getPosition())
			winners.add(car.getName());
	}

	public void printCars() {
		for (Car car : cars) {
			System.out.println(car.toStringCar());
		}
		System.out.println();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public List<Car> getCars() {
		return cars;
	}
}