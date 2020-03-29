/** 
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释： 
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
*/
let maxDistance = function(grid){
    let dx = [0,0,1,-1];
    let dy = [1,-1,0,0];
    let m = grid.length, n = grid[0].length;
    let arr = [];
    for(let i=0; i<m;i++){
        for(let j=0; j<n;j++){
            if(grid[i][j] === 1){
                arr.push([i,j]);
            }
        }
    }
    let hasOcean = false;
    let point = null;
    while(arr.length > 0){
        point = arr.shift();
        let x = point[0], y = point[1];
        for(let i=0;i<4;i++){
            let newX = x+dx[i];
            let newY = y+dy[i];
            if(newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] !== 0){
                continue;
            }
            grid[newX][newY] = grid[x][y]+1;
            hasOcean = true;
            arr.push([newX,newY]);
        }
    }
    if(point === null || !hasOcean){
        return -1;
    }
    return grid[point[0]][point[1]]-1;
};
console.log(maxDistance([[1,0,1],[0,0,0],[1,0,1]]));
console.log(maxDistance([[1,0,0],[0,0,0],[0,0,0]]));