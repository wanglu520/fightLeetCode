package DailyQuestion.java;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK2(int[] A, int K) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : A){
            sum += num;
             // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int mod = (sum % K + K) % K;
            int same = map.getOrDefault(mod, 0);
            res += same;
            map.put(mod, same+1);
        }
        return res;
    }

    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        for(int i=0; i<A.length; i++){
            int sum = A[i];
            if(sum % K == 0){
                res++;
            }
            for(int j=i+1; j<A.length; j++){
                sum += A[j];
                if(sum % K == 0){
                    res++;
                }
            }
        }
        return  res;
    }
}