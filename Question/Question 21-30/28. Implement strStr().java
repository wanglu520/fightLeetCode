class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || haystack == null || haystack.length() < needle.length()){
            return -1;
        }
        if("".equals(needle) || haystack.startsWith(needle)){
            return 0;
        }
        String[] strArr = haystack.split(needle);
        return  (strArr.length == 1 && (strArr[0].length() < haystack.length())) || strArr.length > 1 ? strArr[0].length() : -1;
    }
}