import java.util.Deque;
import java.util.LinkedList;

import Util.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode first = head;
        ListNode temp = head;
        Deque<ListNode> stack = new LinkedList<>();
        //把链表数据维护到栈中；
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        //如果k为链表长度的倍数，刚好旋转几圈回到最开始状态。
        //所以取余为实际要旋转的次数
        if(k >= stack.size()){
            k = k % stack.size();
        }
        //栈顶为最后一个元素
        ListNode end = stack.pop();
        for(int i = 0; i<k; i++){
            //每次循环栈顶为最后一个元素
            ListNode pre = stack.poll();
            end.next = first;
            first = end;
            end = pre;
            pre.next = null;
        }
        return first;
    }
}