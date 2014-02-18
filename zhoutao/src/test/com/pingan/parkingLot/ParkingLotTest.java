package com.pingan.parkingLot;

import junit.framework.Assert;

import org.junit.Test;

public class ParkingLotTest {

	@Test
	public void testParking_should_be_return_certificate_when_capacity_is_not_full_give_a_car() {
		// 准备数据
		ParkingLot parkingLot = new ParkingLot(10);
		Car car = new Car("沪A-123");
		// 测试执行
		Certificate certificate = parkingLot.parking(car);
		// 验证结果
		Assert.assertEquals("沪A-123", certificate.getVehicleNO());
	}

	@Test(expected = CapacityFullException.class)
	public void testParking_should_be_throw_exception_when_capacity_is_full_and_give_a_car() {
		// 准备数据
		ParkingLot parkingLot = new ParkingLot(1);
		Car car = new Car("沪A-111");
		// 测试执行
		parkingLot.parking(car);
		parkingLot.parking(new Car("沪A-112"));
	}

	@Test
	public void testParking_should_be_return_certificate_when_capacity_is_full_and_give_a_car_after_take_a_car() {
		// 准备数据
		ParkingLot parkingLot = new ParkingLot(2);
		Car car = new Car("沪A-111");
		// 测试执行
		Certificate certificate = parkingLot.parking(car);
		parkingLot.parking(new Car("沪A-112"));
		parkingLot.take(certificate);
		// 验证结果
		parkingLot.parking(new Car("沪A-113"));
	}

	@Test
	public void testTake_should_be_return_a_correct_car_when_give_a_valid_certificate() {
		// 准备数据
		ParkingLot parkingLot = new ParkingLot(10);
		Car car = new Car("沪A-123");
		// 测试执行
		Certificate certificate = parkingLot.parking(car);
		Car takeCar = parkingLot.take(certificate);
		// 验证结果
		Assert.assertEquals(car, takeCar);
	}

	@Test
	public void testTake_should_be_return_nothing_when_give_a_invalid_certificate() {
		// 准备数据
		ParkingLot parkingLot = new ParkingLot(10);
		Car car = new Car("沪A-123");
		parkingLot.parking(car);
		Certificate invalidCertificate = new Certificate("沪A-123");
		// 测试执行
		Car takeCar = parkingLot.take(invalidCertificate);
		// 验证结果
		Assert.assertNull(takeCar);
	}

}
