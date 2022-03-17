/**
 * @param {string[]} words
 * @return {string}
 */
//字典树
var longestWord = function(words) {
  const trie = new Trie();
  //把words添加到字典树
  for(let word of words){
   trie.insert(word);
  }
  let res = "";
  for(let word of words){
    if(trie.serch(word)){
      if(word.length > res.length || (word.length === res.length && word.localeCompare(res)<0)){
        res = word;
      }
    }
  }
  return res;
};

class Node{
 constructor(){
   this.children = new Map();
   this.isEnd = false;
 }
}

class Trie{
 constructor(){
   this.children = new Node();
   this.isEnd = false;
 }

 insert(word){
   let node = this;
   for(let i=0; i<word.length; i++){
     const ch = word[i];
     const index = ch.charCodeAt() - "a".charCodeAt();
     if(!node.children[index]){
       node.children[index] = new Node();
     }
     node = node.children[index];
   }
   node.isEnd = true;
 }

 serch(word){
   let node = this;
   for(let i=0; i<word.length; i++){
     const ch = word[i];
     const index = ch.charCodeAt() - "a".charCodeAt();
     if(!node.children[index] || !node.children[index].isEnd){
       return false;
     }
     node = node.children[index];
   }
   return node && node.isEnd;
 }
}