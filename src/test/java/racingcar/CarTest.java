package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
	private final Car car = new Car("avant");

	@Test
	@DisplayName("car 가 정상적으로 초기화 되었는지 확인")
	public void testCarInfo() {
		assertThat(car.getName()).isEqualTo("avant");
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@ParameterizedTest
	@DisplayName("난수가 4이상일 경우 position +1")
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	public void testMove1Position(int input) {
		int before = car.getPosition();
		car.movePosition(input);
		int after = car.getPosition();
		assertThat(after - before).isOne();
	}

	@ParameterizedTest
	@DisplayName("난수가 4미만일 경우 position +0")
	@ValueSource(ints = {0, 1, 2, 3})
	public void testMove0Position(int input) {
		int before = car.getPosition();
		car.movePosition(input);
		int after = car.getPosition();
		assertThat(after - before).isZero();
	}

	@ParameterizedTest
	@DisplayName("-가 정상적으로 반환되는지 확인")
	@CsvSource(value = {"1:-", "2:--", "3:---", "0:''"}, delimiter = ':')
	public void testMakeHyphen(int input, String expected) {
		String hyphen = car.getHyphen(input);
		assertThat(hyphen).isEqualTo(expected);
	}
}
