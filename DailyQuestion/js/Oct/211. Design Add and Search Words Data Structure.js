/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = new WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */
//通过字典数存储和检索单词
var WordDictionary = function() {
  this.TrieNode = new TrieNode();
};

/** 
 * @param {string} word
 * @return {void}
 */
WordDictionary.prototype.addWord = function(word) {
  this.TrieNode.insert(word);
};

/** 
 * @param {string} word
 * @return {boolean}
 */
WordDictionary.prototype.search = function(word) {
  const dfs = (index, node)=>{
    if(index === word.length){
      return node.isEnd;
    }
    const str = word[index];
    if(str !== "."){
      const child = node.children[str.charCodeAt() - 97];
      if(child && dfs(index+1, child)){
        return true;
      }
    }else{
      for(const child of node.children){
        if(child && dfs(index + 1, child)){
          return true;
        }
      }
    }
    return false;
  }
  return dfs(0, this.TrieNode);
};
//字典数
class TrieNode{
  constructor(){
    this.children = new Array(26).fill(0);
    this.isEnd = false;
  }

  insert(word){
    let node = this;
    for(const str of word){
      const index = str.charCodeAt() - 97;
      if(node.children[index] === 0){
        node.children[index]  = new TrieNode();
      }
      node = node.children[index];
    }
    node.isEnd = true;
  }
}