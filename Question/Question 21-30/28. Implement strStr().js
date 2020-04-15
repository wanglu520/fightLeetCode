/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
let strStr = function(haystack, needle){
    haystack = haystack||"";
    if(needle === "" || haystack.startsWith(needle)){return 0;}
    return haystack.indexOf(needle);
}