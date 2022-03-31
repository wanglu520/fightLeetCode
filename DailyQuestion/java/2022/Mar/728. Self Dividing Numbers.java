class Solution {
  public List<Integer> selfDividingNumbers(int left, int right) {
      List<Integer> ansList = new ArrayList();
      for(int num = left; num <= right; num++){
          if(isSelfDividingNumber(num)){
              ansList.add(num);
          }
      }
      return ansList;
  }

  public Boolean isSelfDividingNumber(int num){
      int temp = num;
      while(temp > 0){
          int digit = temp % 10;
          if(digit == 0 || num % digit != 0){
              return false;
          }
          temp /= 10;
      }
      return true;
  }
}