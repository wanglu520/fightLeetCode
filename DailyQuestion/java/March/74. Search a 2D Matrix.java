package DailyQuestion.java.March;

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
      int lenY = matrix.length;
      if(lenY == 0 || matrix[0].length == 0){
          return false;
      }
      int lenX = matrix[0].length - 1;
      int start = 0;
      int end = lenX;
      int mid;
      for(int i = 0; i<lenY; i++){
          if(matrix[i][lenX] == target){
              return true;
          }
          //判断横向最大值是否大于等于目标值，如果大于则目标值可能在其中
          if(matrix[i][lenX] > target){
              //二分搜索
              while (start <= end){
                  mid = start + (end - start) / 2;
                  if(matrix[i][mid] == target){
                      return true;
                  }else if(matrix[i][mid] > target){
                      end = mid - 1;
                  }else {
                      start = mid + 1;
                  }
              }
              //因为是升序所以后面不需要继续遍历必定大于目标值
              break;
          }
      }
      return false;
  }
  //遍历一遍
  public boolean searchMatrix1(int[][] matrix, int target) {
    if(matrix.length == 0 || matrix[0].length == 0){
        return false;
    }
    int m = matrix.length, n = matrix[0].length;
    int l=0, r = m*n-1;
    int mid;
    while (l <= r){
        mid = l + (r-l)/2;
        if(matrix[mid/n][mid%n] == target){
            return true;
        }else if(matrix[mid/n][mid%n] > target){
            r = mid - 1;
        }else {
            l = mid + 1;
        }
    }
    return false;
}
}