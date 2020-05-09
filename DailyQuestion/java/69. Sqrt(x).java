package DailyQuestion.java;

class Solution {
    public int mySqrt(int x) {
        if(x < 0){
            return -1;
        }
        if(x == 0 || x == 1){
            return x;
        }
        int l  = 0;
        int r = x;
        while (l < r){
            int mid = l + (r-l)/2 ;
            long mids = (long)mid * (long)mid;
            if(mids == x){
                return mid;
            }else if(mids < x){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l * l > x ? l-1 : l;
    }
}