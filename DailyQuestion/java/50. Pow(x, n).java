package DailyQuestion.java;

class Solution{
    //快速幂+递归
    public double myPow(double x, int n){
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    public double quickMul(double x, long n){
        if(n == 0){
            return 1.0;
        }
        double y = quickMul(x, n/2);
        return n % 2 == 0 ? y*y : y*y*x;
    }
    //快速幂+迭代
    public double myPow1(double x, int n){
        long N = n;
        return N >= 0 ? quickMul1(x, N) : 1.0 / quickMul(x, -N);
    }
    public double quickMul1(double x, long n){
        double res = 1.0;
        double tempX = x;
        while(n > 0){
            if(n % 2 == 1){
                res *= tempX;
            }
            tempX *= tempX;
            n /= 2;
        }
        return res;
    }
}