/** 
*编写一个函数来查找字符串数组中的最长公共前缀。
*如果不存在公共前缀，返回空字符串 ""。
*示例 1:
*输入: ["flower","flow","flight"]
*输出: "fl"
*示例 2:
*输入: ["dog","racecar","car"]
*输出: ""
*解释: 输入不存在公共前缀。
*说明:
*所有输入只包含小写字母 a-z 。
*/
/**
 * @param {string[]} strs
 * @return {string}
 */
let longestCommonPrefix = (strs)=>{
    let str = strs[0]||"", commonStr="";
    for(let i=1; i<=str.length; i++){
        let tmpStr = str.slice(0, i);
        if(!strs.every((v)=>new RegExp("^"+tmpStr).test(v))){break;}
        commonStr = tmpStr;
    }
    return commonStr;
};
var aa = ["flower","flow","flight"];
console.log(aa.every((v)=>new RegExp("^flo").test(v)));

let longestCommonPrefix = (strs=[])=>{
    const len = strs.length;
    if(len === 0){return ""}
    if(len === 1){return strs[0]}
    let prefix = strs[0];
    for(let i=0; i<len; i++){
      while(strs[i].indexOf(prefix) !==0){
        prefix = prefix.slice(0, prefix.length-1);
        if(prefix === ""){return ""}
      }
    }
    return prefix;
};
let a = "abcdefghjik";
let sta =0, end = -1;
console.log(a.substring(sta, end),1);
console.log(a.substr(sta, end),2);
console.log(a.slice(sta, end),3);
console.log(longestCommonPrefix(["flower","flow","flight"]))