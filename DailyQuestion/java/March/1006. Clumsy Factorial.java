package DailyQuestion.java.March;

class Solution {
  //先乘除后加减，用temp保存每次乘除的值
  public int clumsy(int N) {
      int res = 0;
      int temp = N;
      for(int i = N-1,index=0; i>0; i--,index++){
          if(index%4 == 0){
              temp *= i;
          }else if(index%4 == 1){
              temp /= i;
          }else if(index%4 == 2){
              res += i;
          }else {
              if(index == 3){
                  res += temp;
              }else {
                  res -= temp;
              }
              temp = i;
          }
      }
      return N > 4 ? res-temp : res+temp;
  }

  public int clumsy1(int N) {
    if (N == 1) {
        return 1;
    } else if (N == 2) {
        return 2;
    } else if (N == 3) {
        return 6;
    } else if (N == 4) {
        return 7;
    }

    if (N % 4 == 0) {
        return N + 1;
    } else if (N % 4 <= 2) {
        return N + 2;
    } else {
        return N - 1;
    }
  }
}