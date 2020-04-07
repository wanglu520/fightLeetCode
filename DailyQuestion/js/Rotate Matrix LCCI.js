/**
 *@param {number[][]} matrix
 *@return {void} Do not return anything, modify matrix in-place instead.
 * 给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
 */

let rotate = function(matrix){
    if(matrix.length === 0){
        return matrix;
    }
    let tempMatrix = matrix.concat([]);
    let y = matrix.length;
    let x = matrix[0].length;
    matrix.length=0;
    for(let i = 0; i < x; i++){
        let tempArr = [];
        for(let j = y-1; j >= 0; j--){
            tempArr.push(tempMatrix[j][i]);
        }
        matrix.push(tempArr);
    }
}
let aaa = [[1,2,3],[4,5,6],[7,8,9]];
rotate(aaa);
console.log(aaa);