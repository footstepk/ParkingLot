package com.pingan.parkingLot;

public class App {

	public static void main(String[] args) {
		ParkingLot parkingLot = new ParkingLot(1);
		Car car = new Car("»¦A-123");
		Certificate certificate = parkingLot.parking(car);
		parkingLot.take(certificate);
	}

}
