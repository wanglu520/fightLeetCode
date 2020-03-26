/** 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
*/

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
let mergeTwoLists = function(l1, l2) {
    let tmpL1 = l1;
    let tmpL2 = l2;
    let resultLN = new ListNode();
    let tmpL3 = resultLN;
    while(tmpL1 !== null || tmpL2 !== null){
        if(tmpL1 === null){
            tmpL3.next = tmpL2;
            return resultLN.next;
        }else if(tmpL2 === null){
            tmpL3.next = tmpL1;
            return resultLN.next;
        }
        if (tmpL1.val > tmpL2.val){
            tmpL3.next = tmpL2;
            tmpL2 = tmpL2.next;
        }else{
            tmpL3.next = tmpL1;
            tmpL1 = tmpL1.next;
        }
        tmpL3 = tmpL3.next;
    }
    return resultLN.next
};
function ListNode(val) {
    this.val = val;
    this.next = null;
}
//recursion
let mergeTwoLists = (l1, l2) =>{
    if(l1 === null){
        return l2;
    }
    if(l2 === null){
        return l1;
    }
    if(l1.val > l2.val){
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }else{
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }
}