package com.pingan.parkingLot;

public class CapacityFullException extends RuntimeException {

	private static final String CAPACITY_IS_FULL = "³µÎ»ÒÑÂú";
	private static final long serialVersionUID = 1L;

	public CapacityFullException() {
		super(CAPACITY_IS_FULL);
	}

}
