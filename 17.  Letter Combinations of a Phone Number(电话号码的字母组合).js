/**
 *Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *Example:
 *Input: "23"
 *Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *Note:
 *Although the above answer is in lexicographical order, your answer could be in any order you want.
 *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *示例:
 *输入："23"
 *输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *说明:
 *尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
/**
* @param {string} digits
* @return {string[]}
*/
let letterCombinations = function(digits) {
    const map = {
        "1":[],
        "2":["a", "b", "c"],
        "3":["d", "e", "f"],
        "4":["g", "h", "i"],
        "5":["j", "k", "l"],
        "6":["m", "n", "o"],
        "7":["p", "q", "r", "s"],
        "8":["t", "u", "v"],
        "9":["w", "x", "y", "z"],
    };
    if(!digits){return []}
    let arr =[...digits].map((v)=>map[v]);
    return arr.reduce((v1, v2)=>{
        let arr1 = [];
        if(v1.length === 0){return v2}
        if(v2.length === 0){return v1}
        for(let i=0; i<v1.length; i++){
            for(let j=0; j<v2.length; j++){
                arr1.push(v1[i]+v2[j]);
            }
        }
        return arr1;
    },[]);
};
console.log(letterCombinations("23"));