/**
 *罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *字符          数值
 *I             1
 *V             5
 *X             10
 *L             50
 *C             100
 *D             500
 *M             1000
 *例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 *X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 *C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *示例 1:
 *输入: 3
 *输出: "III"
 *示例 2:
 *输入: 4
 *输出: "IV"
 *示例 3:
 *输入: 9
 *输出: "IX"
 *示例 4:
 *输入: 58
 *输出: "LVIII"
 *解释: L = 50, V = 5, III = 3.
 *示例 5:
 *输入: 1994
 *输出: "MCMXCIV"
 *解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */

 /**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    var romanMap = {"1":"I", "5":"V", "10":"X", "50":"L", "100":"C", "500":"D", "1000":"M",
        "hex":{"0":[1, 5, 10], "1":[10, 50, 100], "2":[100, 500, 1000], "3":[1000, 1000, 1000]}
    };
    var str = num + "";
    var tmp = "1" + "0".repeat(str.length) - 0;
    var numArr = [...str].map((v)=>{
        tmp = tmp/10
        return v * tmp;
    }).reverse();
    return numArr.map((val, key)=>{
        let arr = romanMap.hex[key+""];
        let start = arr[0]+"", half = arr[1]+"", end = arr[2]+"";
        if(val === (end - start)){return romanMap[start]+romanMap[end]}
        if(val >= half){
            return romanMap[half] + romanMap[start].repeat((val - half)/start);
        }else if(val === (half-start)){
            return romanMap[start]+romanMap[half];
        }else{
            return romanMap[start].repeat(val/start);
        }
    }).reverse().join("");
};

let intToRoman = (num)=>{
    const M = ["", "M", "MM", "MMM"];
    const C = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"];
    const X = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"];
    const I = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"];
    return `${M[parseInt(num/1000, 10)]}${C[parseInt((num%1000)/100, 10)]}${X[parseInt((num%100)/10,10)]}${I[parseInt(num%10,10)]}`;
};
console.log(intToRoman(3));