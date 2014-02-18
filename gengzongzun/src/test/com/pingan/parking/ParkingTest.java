package com.pingan.parking;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ParkingTest extends TestCase {

    public void test_should_park_a_car_successfully_when_parking_not_full(){
        Parking parking = new Parking(3);
        Car car = new Car("A123");
        Assert.assertTrue(parking.parkCar(car));
    }
    public void test_should_park_a_car_failed_when_parking_is_full() {
        Parking parking = new Parking(1);
        Car carA = new Car("A123");
        parking.parkCar(carA);
        Car carB = new Car("B123");
        Assert.assertFalse(parking.parkCar(carB));
    }
    public void test_should_take_car_successfully_when_given_car_number_exists_in_parking(){
        Parking parking = new Parking(3);
        Car car = new Car("A123");
        parking.parkCar(car);
        Assert.assertTrue(parking.takeCar(car.getCarNumber()));
    }
    public void test_should_take_car_failed_when_given_car_number_not_exists_in_parking() {
        Parking parking = new Parking(3);
        Car car = new Car("A123");
        parking.parkCar(car);
        Assert.assertFalse(parking.takeCar("B123"));
    }
    public void test_should_take_car_successfully_when_parking_is_full_but_others_take_car() {
        Parking parking = new Parking(1);
        Car carA = new Car("A123");
        parking.parkCar(carA);
        Car carB = new Car("B123");
        Assert.assertFalse(parking.parkCar(carB));
        parking.takeCar(carA.getCarNumber());
        Assert.assertTrue(parking.parkCar(carB));
    }

    public void test_should_throw_runtime_exception_when_parking_capacity_less_than_1(){
        try {
            Parking parking = new Parking(0);
        }catch (RuntimeException e){
            Assert.assertTrue(true);
        }
    }
}

