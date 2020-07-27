package DailyQuestion.java.July;

class Solution {
    //相同数字按位异或为0，遍历t
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0){
            return true;
        }
        int index = 0;
        for(int i=0; i<t.length(); i++){
            if(index >= s.length()){
                return true;
            }
            if((s.charAt(index) ^ t.charAt(i)) == 0){
                index++;
            }
        }
        return index >= s.length();
    }
}