package DailyQuestion.java;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }
    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        //通过优先级队列从小到大排序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(len, (a ,b)->a-b);
        for (int i = 0; i<len; i++){
            priorityQueue.add(nums[i]);
        }
        //提除
        for(int j = 0; j<len-k; j++){
            priorityQueue.poll();
        }
        //返回地k个最大元素
        return priorityQueue.peek();
    }
}