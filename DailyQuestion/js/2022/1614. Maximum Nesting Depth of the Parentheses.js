/**
 * @param {string} s
 * @return {number}
 */
 var maxDepth = function(s) {
  let ans = 0, count = 0;
  for (let i = 0; i < s.length; ++i) {
      const ch = s[i];
      if (ch === '(') {
          ++count;
          ans = Math.max(ans, count);
      } else if (ch === ')') {
          --count;
      }
  }
  return ans;
};