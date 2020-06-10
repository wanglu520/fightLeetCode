package DailyQuestion.java;
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String str = x+"";
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = len-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        return str.equals(sb.toString());
    }
}