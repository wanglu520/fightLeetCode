package DailyQuestion.java.March;

class Solution {
    //从最低位遍历
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0; i < 32; i++){
            res =(res << 1) + (n >>> i & 1);
        }
        return res;
    }
    //位运算分治
    private static final int M1 = 0b01010101010101010101010101010101;
    private static final int M2 = 0b00110011001100110011001100110011;
    private static final int M4 = 0b00001111000011110000111100001111;
    private static final int M8 = 0b00000000111111110000000011111111;
    public int reverseBits1(int n) {
        //一个一组奇偶转换 = 偶转奇数 | 奇转偶
        n = (n >>> 1) & M1 | (n & M1) << 1;
        //2个一组奇偶转换 = 偶转奇数 | 奇转偶
        n = (n >>> 2) & M2 | (n & M2) << 2;
        //4个一组奇偶转换 = 偶转奇数 | 奇转偶
        n = (n >>> 4) & M4 | (n & M4) << 4;
        //8个一组奇偶转换 = 偶转奇数 | 奇转偶
        n = (n >>> 8) & M8 | (n & M8) << 8;
        //前后转换
        return n >>> 16 | n << 16;
    }
    /**
     * 原理
     * 原数据为:12345678
     * 第一轮 奇偶位交换 21436587
     * 第二轮 每两位交换 43218765
     * 第三轮 每四位交换 87654321
     */
}