package racingcar;

public class Racing {
	UserScanner userScanner = new UserScanner();

	public void start() {
		Cars cars = userScanner.scanCars();
	}
}
