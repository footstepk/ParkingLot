package com.pingan.parkingLot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

	private Map<Certificate, Car> parkingSpaces = new ConcurrentHashMap<Certificate, Car>();
	private int parkCapacity;

	ParkingLot(int parkCapacity) {
		this.parkCapacity = parkCapacity;
	}

	private boolean isFull() {
		return this.parkingSpaces.size() >= this.parkCapacity;
	}

	public Certificate parking(Car car) {
		if (this.isFull())
			throw new CapacityFullException();
		Certificate certificate = new Certificate(car.getVehicleNO());
		this.parkingSpaces.put(certificate, car);
		return certificate;
	}

	public Car take(Object certificate) {
		return this.parkingSpaces.remove(certificate);
	}

}
