package DailyQuestion.java;

import java.util.Arrays;

class MinStack {
    private int count;
    private int[] data;
    private int[] min_stack;
    private int minNum;
    /** initialize your data structure here. */
    public MinStack() {
        count = -1;
        data = new int[8];
        min_stack = new int[8];
    }

    public void push(int x) {
        if(count == -1){
            minNum = x;
        }else {
            minNum = Math.min(minNum, x);
        }
        count++;
        ensureCapacityHelper(count);
        data[count] = x;
        min_stack[count] = minNum;
    }

    public void pop() {
        count--;
        if(count >=0 ){
            minNum = min_stack[count];
        }
    }

    public int top() {
        if(count < 0){
            throw new RuntimeException("EmptyStack");
        }
        return data[count];
    }

    public int getMin() {
        if(count < 0){
            throw new RuntimeException("emptyStack");
        }
        return min_stack[count];
    }

    private void ensureCapacityHelper(int len){
        int oldLen = data.length;
        if(len >= oldLen){
            int newLen = oldLen + (oldLen >>> 2);
            if(newLen > Integer.MAX_VALUE){
                newLen = Integer.MAX_VALUE;
            }
            data = Arrays.copyOf(data, newLen);
            min_stack = Arrays.copyOf(min_stack, newLen);
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */