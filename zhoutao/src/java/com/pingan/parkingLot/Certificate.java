package com.pingan.parkingLot;

import java.util.Date;

public class Certificate {

	private String vehicleNO;
	private String id;

	public Certificate(String vehicleNO) {
		this.vehicleNO = vehicleNO;
		this.id = new Date().toString();
	}

	public String getVehicleNO() {
		return this.vehicleNO;
	}

	public String getCertificateId() {
		return this.id;
	}
}
