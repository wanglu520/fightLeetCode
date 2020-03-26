// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

// 示例 1:

// 输入: "abcabcbb"
// 输出: 3 
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 示例 2:

// 输入: "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 示例 3:

// 输入: "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
/**
 * @param {string} s
 * @return {number}
 */
let lengthOfLongestSubstring = (s)=> {
    let tmpStrs = "", maxlength = 0;
    for(let i=0; i < s.length; i++){
        let tmpStr = s.charAt(i);
        if(tmpStrs.indexOf(tmpStr) === -1){
            tmpStrs += tmpStr;
        }else{
            maxlength = tmpStrs.length > maxlength ? tmpStrs.length : maxlength;
            tmpStrs = tmpStrs.slice(tmpStrs.indexOf(tmpStr)+1) + tmpStr;
        }
    }
    return tmpStrs.length > maxlength ? tmpStrs.length : maxlength;
}
// var lengthOfLongestSubstring = function(s) {
//     var arr = s.split("");
// 	var temp="";
// 	var maxLength=0;
// 	for(var i=0; i < arr.length; i++){
// 		if(temp.indexOf(arr[i]) === -1){
// 			temp += arr[i];
// 		}else{
// 			temp = temp.slice(temp.indexOf(arr[i])+1) + arr[i];
// 		}
//         maxLength = maxLength < temp.length ? temp.length : maxLength
// 	}
// 	return maxLength
// };
console.log(lengthOfLongestSubstring("pwwkew"));