/** 
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.
Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
示例:
给定 1->2->3->4, 你应该返回 2->1->4->3.
*/
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
let swapPairs = function(head) {
    if(head === null || head.next === null){
        return head;
    }
    let next = head.next;
    head.next = swapPairs(next.next);
    next.next = head;
    return next;
};
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
let swapPairs = function(head) {
    let pre = new ListNode(0);
    pre.next = head;
    let temp = prel;
    while(temp.next !== null && temp.next.next !== null){
        let start = temp.next;
        let end = temp.next.next;
        temp.next = end;
        start.next = end.next;
        end.next = start;
        temp = start;
    }
    return pre.next;
};

let ListNode = function(val){
    this.val = val;
    this.next = null;
}
