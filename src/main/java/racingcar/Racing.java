package racingcar;

import java.util.List;

public class Racing {
	private final UserScanner userScanner = new UserScanner();

	public void start() {
		Cars cars = userScanner.scanCars();
		int number = userScanner.scanNumber();
		System.out.println("실행결과");
		for (int i = 0; i < number; i++) {
			cars.moveCarsPosition();
			cars.printCars();
		}
		List<String> winners = cars.getWinners();
		printWinners(winners);
	}

	public void printWinners(List<String> winners) {
		System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
	}
}

