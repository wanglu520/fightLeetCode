import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    Set<String> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> track = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        backTrack(nums, track, indexList);
        return list;
    }
    public void backTrack(int[] nums, List<Integer> track, List<Integer> indexList){
        String key = track.toString();
        if(set.contains(key)){
            return;
        }
        set.add(key);
        if(track.size() == nums.length){
            list.add(new ArrayList<>(track));

            return;
        }
        for(int i=0;i<nums.length;i++){
            if(indexList.contains(i)){
                continue;
            }
            track.add(nums[i]);
            indexList.add(i);
            backTrack(nums, track, indexList);
            track.remove(track.size()-1);
            indexList.remove(indexList.size()-1);
        }
    }
}