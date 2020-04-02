package DailyQuestion.java;

import java.util.Arrays;

class MaximumNestingDepthOfTwValidParentheses {
    int count=0;
    public int[] maxDepthAfterSplit(String seq) {
        return Arrays.stream(seq.split("")).mapToInt(v->{
            if(v.equals("(")){
                ++count;
                return count % 2;
            }else{
                int num = count % 2;
                --count;
                return num;
            }
        }).toArray();
    }
}