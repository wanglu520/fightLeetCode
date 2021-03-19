package DailyQuestion.java.March;

import java.util.HashMap;

class ParkingSystem {
  //通过hash保存剩余车位数
  private HashMap<Integer, Integer> parkingSpaceMap;
  public ParkingSystem(int big, int medium, int small) {
      parkingSpaceMap = new HashMap<>();
      parkingSpaceMap.put(1,big);
      parkingSpaceMap.put(2,medium);
      parkingSpaceMap.put(3,small);
  }

  public boolean addCar(int carType) {
      if(parkingSpaceMap.getOrDefault(carType, 0) > 0){
          parkingSpaceMap.put(carType, parkingSpaceMap.get(carType)-1);
          return true;
      }
      return false;
  }
}

/**
* Your ParkingSystem object will be instantiated and called as such:
* ParkingSystem obj = new ParkingSystem(big, medium, small);
* boolean param_1 = obj.addCar(carType);
*/