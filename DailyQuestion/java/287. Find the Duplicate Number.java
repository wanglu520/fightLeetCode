package DailyQuestion.java;
class Solution {
    //快慢指针
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do{//寻找相遇点
            slow = nums[slow];//slow一次走一步
            fast = nums[nums[fast]];//fast一次走两步
        }while (fast != slow);
        slow = 0;//找到相遇点 slow从初始重新开始走，快慢现在一次都走一步
        do{
            slow = nums[slow];
            fast = nums[fast];
        }while (fast != slow);
        return fast;
    }
    
}