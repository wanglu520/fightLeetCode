/**
 * @param {number[]} height
 * @return {number}
 */
let trap = function(height) {
    let len = height.length-1;
    if(height.length < 2){return 0;}
    let maxH = height.indexOf(Math.max(...height));
    let l = 0, count = 0;
    while(l < len){
        if(height[l] === 0){
            l++;
        }else{
            let r = findRight(l, maxH, height);
            if((r-l)===1){
                l++;
            }else{
                let midSum = height.slice(l+1,r).reduce((x,y)=>x+y,0);
                count += Math.min(height[l], height[r]) * (r-l-1) - midSum;
                l = r;
            }
        }
    }
    return count
}

let findRight = function(l, maxH, arr){
    if(l < maxH){
        for(let i=l+1; i <= maxH; i++){
            if(arr[l] <= arr[i]){
                return i;
            }
        }
    }else{
        let tempArr = arr.slice(l+1);
        return l+tempArr.indexOf(Math.max(...tempArr))+1;
    }
}


let trap1 = function(height) {
    if(height.length < 2){return 0;}
    let leftMax = 0, rightMax = 0, count;
    let l = 0, r = height.length-1;
    while(l < r){
        leftMax = Math.max(leftMax, height[l]);
        rightMax = Math.max(rightMax, height[r]);
        if(leftMax < rightMax){
            count += leftMax - height[l];
            l++;
        }else{
            count += rightMax - height[r];
            r--;
        }
    }
    return count;
};