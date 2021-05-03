package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserScannerTest {
	private final UserScanner userScanner = new UserScanner();

	@Test
	@DisplayName("문자열에 대한 자동차이름을 정상적으로 반환")
	public void testGenerateCars() {
		String input = "kia,benz";
		Cars cars = userScanner.generateCars(input);
		assertThat(cars.getCars().get(0).getName()).isEqualTo("kia");
		assertThat(cars.getCars().get(1).getName()).isEqualTo("benz");
	}

	@ParameterizedTest
	@DisplayName("이름의 길이가 1 이상 5이하인 경우 true 반환")
	@ValueSource(strings = {"kia", "kia,benz", "kia,h d", "ben z,hyund"})
	public void testNameLength1Up5Down(String input) {
		boolean isValidInput = userScanner.isValidInput(input);
		assertThat(isValidInput).isTrue();
	}

	@Test
	@DisplayName("이름의 길이가 5 초과인 경우 false 반환")
	public void testNameLength5Up() {
		String input = "toyota";
		boolean isValidInput = userScanner.isValidInput(input);
		assertThat(isValidInput).isFalse();
	}

	@ParameterizedTest
	@DisplayName("이름의 길이가 0이 있을 경우 false 반환")
	@ValueSource(strings = {"kia,", ",kia,", "kia,,honda", "kia,,", ",,kia"})
	public void testValidInputFalse(String input) {
		boolean isValidInput = userScanner.isValidInput(input);
		assertThat(isValidInput).isFalse();
	}
}
