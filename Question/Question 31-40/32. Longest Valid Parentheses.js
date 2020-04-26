/**
 * @param {string} s
 * @return {number}
 */
let longestValidParentheses = function(str){
	let arr = str.split("");
    let stack =[-1];
    let count=0;
    for(let i=0;i<arr.length;i++){
        if(arr[i]==="("){
            stack.push(i);
        }else{
            stack.pop();
            if(stack.length === 0){
                stack.push(i);
            }
            count = Math.max(count, i-stack[stack.length-1]);
        }
    }
    return count;
}
console.log(longestValidParentheses("(()"));
console.log(longestValidParentheses(")()())"));
console.log(longestValidParentheses("()(()"));
console.log(longestValidParentheses("()(())"));