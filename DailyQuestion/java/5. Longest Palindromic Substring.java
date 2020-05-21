package DailyQuestion.java;
//中心拓展
    //类型1：aba, 类型2：abba
    class Solution {
        public String longestPalindrome(String s) {
            if(s == null || s.length() == 0){
                return "";
            }
            int start = 0, end = 0;
            int len = s.length();
            for(int i=0; i<len; i++){
                int subLen1 = expandAroundCenter(s, i, i);
                int subLen2 = expandAroundCenter(s, i, i+1);
                int maxSubLen = Math.max(subLen1, subLen2);
                if(maxSubLen > (end - start)){
                    start = i - ((maxSubLen-1)>>1);
                    end = i + (maxSubLen>>1);
                }
            }
            return s.substring(start, end+1);
        }
        public int expandAroundCenter(String s, int left, int right){
            while (left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                right++;
                left--;
            }
            return right - left -1;
        }
    }