package DailyQuestion.java.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    //通过哈希表记录其中一个数组数字的出现次数（数字为key，次数为value），
    // 再遍历另一个数组，如果哈希表存在这个数字，次数字就是我们要找的，同时value-1；
    //value为0时删除这个数字,当哈希表长度为0时提前结束遍历返回结果
    public int[] intersect2(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect2(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for(int num : nums2){
            int count = map.getOrDefault(num,0);
            if(count > 0){
                res[index++] = num;
                count--;
                if(count > 0){
                    map.put(num, count);
                }else {
                    map.remove(num);
                }
            }
            if(map.size() == 0){
                return Arrays.copyOfRange(res,0,index);
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
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