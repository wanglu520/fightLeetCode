package DailyQuestion.java.March;

import Util.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
      if (head == null) {
          return head;
      }
      //把开头当做普通节点处理
      ListNode temp = new ListNode(-1, head);

      ListNode cur = temp;
      while (cur.next != null && cur.next.next != null) {
          if (cur.next.val == cur.next.next.val) {
              int x = cur.next.val;
              while (cur.next != null && cur.next.val == x) {//相同往后移
                  cur.next = cur.next.next;
              }
          } else {
              cur = cur.next;
          }
      }

      return temp.next;
  }
}