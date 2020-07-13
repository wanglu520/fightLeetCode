package DailyQuestion.java.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    //数组先排序，然后从第一个开始对比小的数索引+1 
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length,
                len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2){
            if(nums1[index1] ==  nums2[index2]){
                res.add(nums1[index1]);
                index1++;
                index2++;
            }else if(nums1[index1] < nums2[index2]){
                index1++;
            }else {
                index2++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}