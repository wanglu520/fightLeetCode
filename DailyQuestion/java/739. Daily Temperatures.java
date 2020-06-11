package DailyQuestion.java;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    //暴力
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            int temp=0;
            for(int j=i+1; j<len;j++){
                if(T[i] < T[j]){
                    temp = j -i;
                    break;
                }
            }
            res[i] = temp;
        }
        return res;
    }
    public int[] dailyTemperatures1(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0; i<len; i++){
            int temp = T[i];
            while(!stack.isEmpty() && temp > T[stack.peek()]){
                int top = stack.pop();
                res[top] = i - top;
            }
            stack.push(i);
        }
        return res;
    }
}