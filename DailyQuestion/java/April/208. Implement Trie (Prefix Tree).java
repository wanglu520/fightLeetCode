package DailyQuestion.java.April;

class Trie {
  private Trie[] chrilren;
  private boolean isEnd;
  /** Initialize your data structure here. */
  public Trie() {
      chrilren = new Trie[26];
      isEnd = false;
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
      if(word == null){
          return;
      }
      Trie node = this;
      for(char s : word.toCharArray()){
          int index = s - 'a';
          if(node.chrilren[index] == null){//不存在创建
              node.chrilren[index] = new Trie();
          }
          node = node.chrilren[index];
      }
      node.isEnd = true;//到这存在一个完整的单词
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
      Trie node = searchPrefix(word);
      return node != null && node.isEnd == true;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
      Trie node = searchPrefix(prefix);
      return node != null;
  }

  private Trie searchPrefix(String prefix){
      if(prefix == null){
          return null;
      }
      Trie node = this;
      for (char s : prefix.toCharArray()){
          int index = s - 'a';
          if(node.chrilren[index] == null){
              return null;
          }
          node = node.chrilren[index];
      }
      return node;
  }
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/