/**
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
示例 1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
L     D     R
E   O E   I I
E C   I H   N
T     S     G
 */
/**
 * @param {String} s 
 * @param {number} numRows 
 * @returns {String}
 */
let convert = function(s, numRows) {
    let addNum = 2 * numRows - 2, str="";
    if(numRows === 1){return s}
    for(let i = 0; i < numRows; i++){
        let startNum = i, tmp = addNum - i*2;
        while(startNum < s.length){
            str += s[startNum]||"";
            if(i > 0 && i < numRows-1 && (startNum + tmp) < s.length){
                str += s[startNum + tmp];
            }
            startNum += addNum; 
        }
    }
    return str;
}

var convert = function(s, numRows) {
    if(numRows === 1){return s}
    var length = s.length,arr=[];
    var cycleLen = 2 * numRows - 2;
    for(var i=0; i < numRows; i++){
        for(var j=0; j+i < length; j += cycleLen){
            arr.push(s[j+i]);
            if(i !== 0 && i !== numRows-1 && j + cycleLen - i < length){
               arr.push(s[j + cycleLen - i]);
            }
        }
    }
    return arr.join("");
};