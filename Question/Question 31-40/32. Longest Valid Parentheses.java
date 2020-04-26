import java.util.Stack;

class aa {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(-1);
        int maxNum = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.add(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.add(i);
                }
                maxNum = Math.max(maxNum, i - stack.peek());
            }
        }
        return maxNum;
    }
}