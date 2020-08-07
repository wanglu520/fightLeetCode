package DailyQuestion.java.August;

class Solution {
    //字符串从尾部开始遍历，一一相加
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int temp = 0;
        while (len1 >= 0 || len2 >= 0){
            //转换成int类型
            int val1 = len1 >= 0 ? num1.charAt(len1--) - '0' : 0;
            int val2 = len2 >= 0 ? num2.charAt(len2--) - '0' : 0;
            int tempSum = val1 + val2 + temp;
            //大于10情况
            res.append(tempSum % 10);
            temp = tempSum / 10;
        }
        //遍历结束temp不为0，向前进一位
        if(temp > 0){
            res.append(temp);
        }
        return res.reverse().toString();
    }
}