package DailyQuestion.java.March;

import Util.ListNode;

class Solution {
  public ListNode deleteDuplicates(ListNode head) {
      if(head == null){
          return head;
      }
      ListNode cur = head;
      while (cur.next != null){
          if(cur.next.val == cur.val){//相同next往后移一个
              cur.next = cur.next.next;
          }else {
              cur = cur.next;
          }
      }
      return head;
  }
}