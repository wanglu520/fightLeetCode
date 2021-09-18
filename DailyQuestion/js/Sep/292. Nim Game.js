/**
 * @param {number} n
 * @return {boolean}
 */
//剩4块石头，先手的必输
 var canWinNim = function(n) {
  return n%4 !== 0;
};