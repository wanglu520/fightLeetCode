/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
/**
 * @param {number} n
 * @return {string[]}
 */
let generateParenthesis = function(n) {
    let res = [];
    if(n === 0){
        res.push("");
    }else{
        for(let c=0; c < n; c++){
            for(let left of generateParenthesis(c)){
                for(let right of generateParenthesis(n -1 -c)){
                    res.push(`(${left})${right}`);
                }
            }
        }
        
    }
    return res;
};
console.log(generateParenthesis(3));