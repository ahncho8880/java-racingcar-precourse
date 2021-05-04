package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserScanner {
	private static final int MAX_LENGTH = 5;
	private static final int MIN_LENGTH = 1;
	private static final String numberRegex = "^[0-9]+$";
	private final Scanner scanner = new Scanner(System.in);

	public Cars scanCars() {
		System.out.println("경주 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = scanner.nextLine();
		while (!isValidInput(input)) {
			System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			input = scanner.nextLine();
		}
		return generateCars(input);
	}

	public boolean isValidInput(String input) {
		if (input.charAt(input.length() - 1) == ',') {
			return false;
		}
		String[] names = input.split(",");
		List<Boolean> lengths = new ArrayList<>();
		for (String name : names) {
			lengths.add(checkLength(name));
		}
		return !lengths.contains(Boolean.FALSE);
	}

	private boolean checkLength(String name) {
		return name.length() >= MIN_LENGTH && name.length() <= MAX_LENGTH;
	}

	public Cars generateCars(String input) {
		StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
		Cars cars = new Cars();
		while (stringTokenizer.hasMoreTokens()) {
			String carName = stringTokenizer.nextToken();
			Car car = new Car(carName);
			cars.addCar(car);
		}
		return cars;
	}

	public int scanNumber() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String input = scanner.next();
		while (!isValidNumber(input)) {
			System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			input = scanner.next();
		}
		return Integer.parseInt(input);
	}

	public boolean isValidNumber(String number) {
		if (number.charAt(0) == '0') {
			return false;
		}
		return number.matches(numberRegex);
	}
}
