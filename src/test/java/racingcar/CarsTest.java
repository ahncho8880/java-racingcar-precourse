package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	Cars cars = new Cars();
	Car car1 = new Car("car1");
	Car car2 = new Car("car2");
	Car car3 = new Car("car3");

	public void setTest() {
		cars.addCar(car1);
		cars.addCar(car2);
		cars.addCar(car3);
	}

	@Test
	@DisplayName("car 가 정상적으로 추가되는지 확인")
	public void testAddCarList() {
		setTest();
		assertThat(cars.getCars().get(0).getName()).isEqualTo("car1");
		assertThat(cars.getCars().get(1).getName()).isEqualTo("car2");
		assertThat(cars.getCars().get(2).getName()).isEqualTo("car3");
	}

}
