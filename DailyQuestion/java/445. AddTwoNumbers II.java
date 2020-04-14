package DailyQuestion.java;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l2 == null){return l1;}
        if(l1 == null){return l2;}
        ListNode reL1 = reverseListNode(l1);
        ListNode reL2 = reverseListNode(l2);
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        int num=0;
        while (reL1 != null || reL2 != null){
            if(reL1 == null){
                if(num == 0){
                    temp.next = reL2;
                }else {
                    while (reL2 != null){
                        if(num == 0){
                            temp.next = reL2;
                            break;
                        }
                        int val = reL2.val + num;
                        if(val >=10){
                            val = val % 10;
                            num = 1;
                        }else {
                            num = 0;
                        }
                        temp.next = new ListNode(val);
                        temp = temp.next;
                        reL2 = reL2.next;
                    }
                }
                break;
            }
            if(reL2 == null){
                if(num == 0){
                    temp.next = reL1;
                }else {
                    while (reL1 != null){
                        if(num == 0){
                            temp.next = reL1;
                            break;
                        }
                        int val = reL1.val + num;
                        if(val >=10){
                            val = val % 10;
                            num = 1;
                        }else {
                            num = 0;
                        }
                        temp.next = new ListNode(val);
                        temp = temp.next;
                        reL1 = reL1.next;
                    }
                }
                break;
            }
            int val = reL1.val + reL2.val + num;
            if(val >=10){
                num = 1;
                val = val % 10;
            }else {
                num = 0;
            }
            reL1 = reL1.next;
            reL2 = reL2.next;
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        result = reverseListNode(result.next);
        if(num == 1){
            ListNode temp1 = new ListNode(1);
            temp1.next = result;
            result = temp1;
        }
        return result;
    }
    public static ListNode reverseListNode(ListNode ln){
        if(ln == null){
            return ln;
        }
        ListNode result = new ListNode(-1);
        ListNode p = ln;
        while (p != null){
            ListNode temp = p.next;
            p.next = result.next;
            result.next = p;
            p = temp;
        }
        return result.next;
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
}
