package racingcar;

public class Racing {
	UserScanner userScanner = new UserScanner();

	public void start() {
		Cars cars = userScanner.scanCars();
		int number = userScanner.scanNumber();
		System.out.println("실행결과");
		for (int i = 0; i < number; i++) {
			cars.moveCarsPosition();
			cars.printCars();
		}
	}
}
