/**
 * @param {string} seq
 * @return {number[]}
 */
let maxDepthAfterSplit = function(seq) {
    let count=0;
    return seq.split("").map((val, idnex)=>{
        if(val === "("){
            ++count;
            return count%2;
        }else{
            let num = count%2;
            --count;
            return num;
        }
    })
}