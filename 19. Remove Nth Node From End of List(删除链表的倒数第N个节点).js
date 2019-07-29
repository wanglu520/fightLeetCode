/**
Given a linked list, remove the n-th node from the end of list and return its head.
Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Follow up:
Could you do this in one pass?
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。
进阶：
你能尝试使用一趟扫描实现吗？
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
 * @param {number} n
 * @return {ListNode}
 */
let ListNode = {
    next : null
};
let removeNthFromEnd = function(head, n) {
    ListNode.next = head;
    let next = ListNode.next, count = 0;
    while(next !== null){
        count++;
        next = next.next;
    }
    if(count < n || n <= 0){return head}
    let tmp = ListNode;
    for(let i = 0; i < count - n; i++){
        tmp = tmp.next;
    }
    tmp.next = tmp.next.next;
    return ListNode.next;
};