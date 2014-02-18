package java.com.pingan.parking;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zz
 * Date: 14-2-18
 * Time: 下午3:21
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy {
    private List<Parking> parkingList ;

    public ParkingBoy(List<Parking> parkingList){
        if (parkingList == null || parkingList.size()==0){
            this.parkingList = parkingList;
        }
    }

    private Parking getEmptyParking(){
        for(int i = 0; i<parkingList.size();i++){
            if(!parkingList.get(i).isFull()){
                return parkingList.get(i);
            }
        }
        throw new RuntimeException("All ParkingLot is full!");
    }

    public void parkCar(Car car){
        Parking parking = this.getEmptyParking();
        parking.parkCar(car);
    }

    public Car takeCar(String carNumer){
         return null;
    }
}
