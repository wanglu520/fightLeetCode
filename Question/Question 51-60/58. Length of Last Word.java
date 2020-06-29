class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null){
            return 0;
        }
        s = s.trim();//去掉开头结尾的空格；
        int len = s.length();
        //从后往前遍历，出现空格时  最后一个单词的长度为len-i-1;
        for(int i = len-1; i>0; i--){
            if(s.charAt(i) == ' '){
                return len - i -  1;
            }
        }
        //只有一个单词返回s的长度
        return len;
    }
    //根据空格把字符串切割成数组，返回数组最后一个单词的长度
    public int lengthOfLastWord1(String s) {
        if(s == null){
            return 0;
        }
        String[] arr = s.split(" ");
        return arr.length > 0 ? arr[arr.length-1].length() : 0;
    }
}