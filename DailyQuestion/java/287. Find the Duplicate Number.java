package DailyQuestion.java;

import java.util.HashSet;
import java.util.Set;

class Solution {

    // 快慢指针
    public int findDuplicate(final int[] nums) {
        int fast = 0;
        int slow = 0;
        do{//寻找相遇点
            slow = nums[slow];//slow一次走一步
            fast = nums[nums[fast]];//fast一次走两步
        }while (fast != slow);
        slow = 0;//找到相遇点 slow从初始重新开始走，快慢现在一次都走一步
        while (fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        };
        return fast;
    }
    //通过哈希表记录  再次出现返回.空间复杂度o（1-n）
    public int findDuplicate1(final int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for(final int num : nums){
            if(set.contains(num)){
                return num;
            }else{
                set.add(num);
            }
        }
        return -1;
    }
}