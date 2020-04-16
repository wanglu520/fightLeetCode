import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return resultList;
        }
        int wordLen = words[0].length();
        int len = words.length * wordLen;
        int start = 0;
        int end = len;
        while (start < s.length() && end <= s.length()){
            String tempStr = s.substring(start,end);
            for(int i =0;i<words.length;i++){
                int index = tempStr.indexOf(words[i]);
                while (index != -1 && (index+wordLen)%wordLen != 0){
                    index = tempStr.indexOf(words[i],index+1);
                }
                if(index == -1){
                    break;
                }
                tempStr = tempStr.substring(0,index)+tempStr.substring(index+wordLen);
                if(i == words.length-1){
                    resultList.add(start);
                }
            }
            start++;
            end++;
        }
        return resultList;
    }
}