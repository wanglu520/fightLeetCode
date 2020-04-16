/**
 * @param {number[][]} intervals
 * @return {number[][]}
 * [[1,4],[4,5]]
 * [[1,4],[5,6]]
 * [[1,3],[2,6],[8,10],[15,18]]
 */
let merge = function(intervals) {
    if(intervals.length === 1){
        return intervals;
    }
    let result=[];
    intervals = intervals.sort((o1,o2)=>o1[0]-o2[0])
    for(let i=0; i<intervals.length;i++){
        if(i+1 === intervals.length){
            result.push(intervals[i]);
            break;
        }
        if(intervals[i][1] >= intervals[i+1][0]){
            let left = intervals[i][0];
            let right = intervals[i+1][1] > intervals[i][1] ? intervals[i+1][1] : intervals[i][1];
            let temArr = [left, right];
            intervals[i+1] = temArr;
            continue;
        }
        result.push(intervals[i]);
    }
    return result;
};
console.log(merge([[1,4],[0,2],[3,5]]))
console.log(merge([[2,3],[4,5],[6,7],[8,9],[1,10]]))
console.log(merge([[1,4],[0,1]]));
console.log(merge([[1,4],[0,4]]));
console.log(merge([[1,4],[4,5]]));
console.log(merge([[1,4],[5,6]]));
console.log(merge([[1,3],[2,6],[8,10],[15,18]]));