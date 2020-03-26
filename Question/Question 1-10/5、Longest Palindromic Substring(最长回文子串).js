/* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：
输入: "babad"
      dabab
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：
输入: "cbbd"
输出: "bb" 
 */
/**
 * @param {string} s
 * @return {string}
 */
let longestPalindrome = (s)=> {
    let maxStr = s.charAt(0)||"";
    if(s.length === 1) return s;
    for(let i = 0; i < s.length; i++){
        let lastStrIndex = s.lastIndexOf(s.charAt(i));
        while(i !== lastStrIndex){
            let tmpStr = s.slice(i, lastStrIndex+1);
            lastStrIndex = s.lastIndexOf(s.charAt(i), lastStrIndex-1);
            if(tmpStr === tmpStr.split("").reverse().join("")){
                maxStr.length <= tmpStr.length && (maxStr = tmpStr);
            }
        }
    }
    return maxStr;
};
/**
 * @param {String} s 
 * Manacher 算法
 */
let longestPalindrome = function (s) {
    if (s.length == 1) {
       return s;
    }
    let str = '#' + s.split('').join('#') + '#';
    let rl = [];
    let mx = 0;
    let pos = 0;
    let ml = 0;
    for (let i = 0; i < str.length; i++){
        console.log(`rl:${JSON.stringify(rl)}, mx:${mx}, pos:${pos}, ml:${ml}`);
        if (i < mx) {
            rl[i] = Math.min(rl[2 * pos - i], mx - i);
        } else {
            rl[i] = 1;
        }
        while (i - rl[i] > 0 && i + rl[i] < str.length && str[i - rl[i]] == str[i + rl[i]]) {
            rl[i]++;
        }
        if (rl[i] + i - 1 > mx) {
            mx = rl[i] + i - 1;
            pos = i;
        }
        if (ml < rl[i]) {
            ml = rl[i];
            sub = str.substring(i - rl[i]+1, i + rl[i]);
        }
    }
    return sub.split('#').join('').trim();
}
longestPalindrome("babad");
/**
 * @param {String} s 
 * @returns {String}
 * 中心扩展算法
 */
let longestPalindrome = function(s){
    if(s === null || s.length < 1){return ""}
    let start = 0, end = 0;
    for(let i = 0; i < s.length; i++){
        let len1 = expandAroundCenter(s, i, i);
        let len2 = expandAroundCenter(s, i, i+1);
        let len = Math.max(len1, len2);
        if(len > (end - start)){
            start = i - ((len -1) / 2 |0);
            end = i + (len / 2 | 0);
            console.log(i, len, start, end);
        }
    }
    return s.slice(start, end+1);
};
/**
 * @param {String} s
 * @param {String} left
 * @param {String} right
 * @returns {String} 
 */
let expandAroundCenter = function(s, left, right){
    let len = s.length;
    while(left >= 0 && right < len && s[left] === s[right]){
        left--;
        right++;
    }
    return right - left - 1;
};
console.log(longestPalindrome("cbbd"));