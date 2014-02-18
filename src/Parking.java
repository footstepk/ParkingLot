import java.util.HashMap;
import java.util.Map;

public class Parking {
    private int capacity;
    private Map<String, Car> carMap;
    public Parking(int capacity){
        if(capacity <=0){
            throw  new RuntimeException("capacity must > 0!");
        }
        carMap = new HashMap<String, Car>();
        this.capacity = capacity;
    }
    public boolean parkCar(Car car){
        if(!isFull()){
            carMap.put(car.getCarNumber(), car);
            return true;
        }
        return false;
    }
    private boolean isFull(){
        return carMap.size() >= capacity;
    }
    public boolean takeCar(String carNumber){
        if(carMap.get(carNumber)!=null){
            carMap.remove(carNumber);
            return true;
        }
        return false;
    }
}
