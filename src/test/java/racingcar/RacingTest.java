package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
	Racing racing = new Racing();

	public void setTest1(Cars cars) {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");
		cars.addCar(car1);
		cars.addCar(car2);
		cars.addCar(car3);
	}

	@Test
	@DisplayName("우승자가 1명일 경우")
	public void testGetWinner() {
		Cars cars = new Cars();
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");
		car1.position = 1;
		car2.position = 2;
		car3.position = 3;
		cars.addCar(car1);
		cars.addCar(car2);
		cars.addCar(car3);
		assertThat(racing.getWinners(cars)).containsExactly("car3");
	}

	@Test
	@DisplayName("우승자가 1명이상일 경우")
	public void testGetWinners() {
		Cars cars = new Cars();
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");
		car1.position = 1;
		car2.position = 3;
		car3.position = 3;
		cars.addCar(car1);
		cars.addCar(car2);
		cars.addCar(car3);
		assertThat(racing.getWinners(cars)).containsExactly("car2", "car3");
	}
}
