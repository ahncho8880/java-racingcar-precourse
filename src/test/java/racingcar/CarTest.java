package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	private final Car car = new Car("avant");

	@Test
	@DisplayName("car 가 정상적으로 초기화 되었는지 확인")
	public void testCarInfo() {
		assertThat(car.getName()).isEqualTo("avant");
		assertThat(car.getPosition()).isEqualTo(0);
	}
}
