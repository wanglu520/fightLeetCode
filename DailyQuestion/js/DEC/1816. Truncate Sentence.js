/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
 var truncateSentence = function(s, k) {
  return s.match(/[a-zA-z]+/g).slice(0, k).join(' ')
};