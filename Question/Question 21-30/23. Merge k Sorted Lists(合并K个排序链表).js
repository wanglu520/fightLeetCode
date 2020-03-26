/** 
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
Example:
 Input:
 [
   1->4->5,
   1->3->4,
   2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 示例:
 输入:
 [
   1->4->5,
   1->3->4,
   2->6
 ]
 输出: 1->1->2->3->4->4->5->6
*/
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
let mergeKLists = function(lists) {
    if(lists.length === 0){
        return null;
    }
    if(lists.length === 1){
        return lists[0];
    }
    let resList = lists[0];
    tmpLists = lists.slice(1);
    for(let list of tmpLists){
        resList = mergeTwoLists(resList, list);
    }
    return resList;
};
let mergeTwoLists = (l1, l2)=>{
    if(l1 === null){
        return l2;
    }
    if(l2 === null){
        return l1;
    }
    if(l1.val > l2.val){
        l2.next = mergeTwoLists(l1, l2.next);
        return l2
    }else{
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }
}
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 * 排序
 */
let mergeKLists = function(lists) {
    let tmpLists = [];
    for(let list of lists){
        while(list){
            tmpLists.push(list.val);
            list = list.next;
        }
    }
    tmpLists.sort((a, b)=>a-b);
    let resl = head = listNode(0);
    for(let val of tmpLists){
        head.next = listNode(val);
        head = head.next;
    }
    return resl.next;
}
let listNode =(val)=>{
    return {val:val, next:null};
}


