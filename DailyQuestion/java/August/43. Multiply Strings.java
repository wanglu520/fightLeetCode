package DailyQuestion.java.August;

class Solution {
    //每次遍历先相乘  再把乘积和上一次的值相加
    public String multiply(String num1, String num2) {
        //num1或num2其中之一为0 直接返回0
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int temp = 0, val1, val2, sum;
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        for(int i = len1; i>=0; i--){
            val1 = num1.charAt(i) - '0';
            StringBuilder sb = new StringBuilder();
            //十位百位。。。相乘末尾添加0
            for(int f = 0; f < len1-i; f++){
                sb.append(0);
            }
            //相乘
            for(int j = len2; j>=0; j--){
                val2 = num2.charAt(j) - '0';
                sum = val1 * val2 + temp;
                sb.append(sum % 10);
                temp = sum / 10;
            }
            //如果遍历结束向前进了一位
            if(temp > 0){
                sb.append(temp);
                temp = 0;
            }
            //本次遍历的值与上一次累加的值相加
            if(res.length() == 0){
                res = sb;
            }else {
                int resLen = res.length();
                int sbLen = sb.length();
                int index = 0;
                StringBuilder resTemp = new StringBuilder();
                while (resLen > index || sbLen > index){
                    val1 = resLen > index ? res.charAt(index) - '0' : 0;
                    val2 = sbLen > index ? sb.charAt(index) - '0' : 0;
                    sum = val1 + val2 + temp;
                    resTemp.append(sum % 10);
                    temp = sum / 10;
                    index++;
                }
                if(temp > 0){
                    resTemp.append(temp);
                    temp = 0;
                }
                res = resTemp;
            }
        }
        return res.reverse().toString();
    }
}