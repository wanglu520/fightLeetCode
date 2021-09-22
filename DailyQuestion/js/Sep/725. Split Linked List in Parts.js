/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode[]}
 */
//先遍历获取链表长度len，每个小链表长度为len/k，数组前len%k个小链表需要多放一个node。
//len<k,数组补k-len个null
 var splitListToParts = function(head, k) {
  let temp = head, len = 0;
  while(temp !== null){
      len++;
      temp = temp.next;
  }
  const res = [];
  let total = len / k | 0, sur = len % k;
  temp = head;
  while(temp !== null){
        //前len % k个链表长度+1
      let count = total + (sur-- > 0 ? 1 : 0);
      const curr = temp;
      while(count > 1 && temp !== null){
          temp = temp.next;
          count--;
      }
      const next = temp.next;
      temp.next = null;
      temp = next;
      res.push(curr);
  }
  for(let i = k-len; i>0; i--){
      res.push(null);
  }
  return res;
};

var splitListToParts = function(head, k) {
  let n = 0;
  let temp = head;
  while (temp != null) {
      n++;
      temp = temp.next;
  }
  let quotient = Math.floor(n / k), remainder = n % k;

  const parts = new Array(k).fill(null);
  let curr = head;
  for (let i = 0; i < k && curr != null; i++) {
      parts[i] = curr;
      let partSize = quotient + (i < remainder ? 1 : 0);
      for (let j = 1; j < partSize; j++) {
          curr = curr.next;
      }
      const next = curr.next;
      curr.next = null;
      curr = next;
  }
  return parts;
};