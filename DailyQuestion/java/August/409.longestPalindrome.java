class longestPalindrome {
  public int longestPalindrome(String s) {
    int res = 0;
    Map<Character, Integer> map = new HashMap<>();
    for(int i=0; i<s.length(); i++){
        char ch = s.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    boolean hasOddCount = false;
    for(char ch1 : map.keySet()){
        int temp = map.get(ch1);
        if((temp % 2) == 0){
            res += temp;
        }else {
            hasOddCount = true;
            res += (temp - 1);
        }
    }
    return hasOddCount ? res + 1 : res;
}
}