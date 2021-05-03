package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public List<Car> getCars() {
		return cars;
	}
}
