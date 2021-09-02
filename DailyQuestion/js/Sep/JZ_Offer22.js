/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
//双指针，快慢指针间隔k，快指针到到末端时，慢指针所在节点为返回节点
 var getKthFromEnd = function(head, k) {
   let fast = head, slow = head;
   while(fast && k>0){
     [fast, k] = [fast.next, k-1];
   }
   while(fast){
     [fast, slow] = [fast.next, slow.next];
   }
   return slow;
};