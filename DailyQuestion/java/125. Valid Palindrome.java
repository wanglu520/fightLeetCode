package DailyQuestion.java;

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null){
            return false;
        }
        //去掉非字母数字的字符串，再把字母转成小写
        s = s.replaceAll("\\W","").toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        //判断颠倒的字符串和原字符串是的相同
        return sb.reverse().toString().equals(s);
    }
}