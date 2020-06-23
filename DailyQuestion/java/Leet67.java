package DailyQuestion.java;

class Solution {
    public String addBinary(String a, String b) {
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        int len_A = a.length()-1;
        int len_B = b.length()-1;
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        while (len_A >= 0 || len_B >= 0){
            int numA = 0;
            int numB = 0;
            if(len_A >= 0){
                numA = a.charAt(len_A) - '0';
                len_A--;
            }
            if(len_B >= 0){
                numB = b.charAt(len_B) - '0';
                len_B--;
            }
            int sum = numA + numB + temp;
            sb.append(sum % 2);
            temp = sum / 2;
        }
        if (temp > 0){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}