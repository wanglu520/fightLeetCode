/**
 * 前缀树
 */
class Trie{
  constructor(){
    this.children = {};
    this.isEnd = false;
  }
/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
 insert(word){
   if(!word){
     return;
   }
   let node = this;
   for(const s of word){
     if(!node.children[s]){
       node.children[s] = new Trie();
     }
     node = node.children[s];
   }
   node.isEnd = true;
 }
 /**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
  search(word) {
    const node = this.searchPrefix(word);
    return node !== null && node.isEnd === true;
  };
  /**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
  startsWith(prefix) {
    return this.searchPrefix(prefix) !== null;
  };
/**
 * @param {string} prefix
 * @return {boolean}
 */
  searchPrefix(word) {
    if(!word){
      return null;
    }
    let node = this;
    for(const s of word){
      if(!node.children[s]){
        return null;
      }
      node = node.children[s];
    }
    return node;
  };
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */