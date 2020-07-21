import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();
    //回溯（超时了）
    public String getPermutation(int n, int k) {
        LinkedList<String> link = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();
        backtrack(link, sb, n, k);
        return link.get(k-1);
    }
    public void backtrack(Deque<String> link, StringBuilder sb, int n, int k){
        if(sb.length() == n){
            link.add(sb.toString());
            return;
        }
        for(int i = 1; i<=n; i++){
            if(set.contains(i)){
                continue;
            }
            set.add(i);
            sb.append(i);
            backtrack(link, sb, n, k);
            if(link.size() >= k){
                break;
            }
            set.remove(i);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}