//双向链表+hashMap
var AllOne = function() {
  this.root = new Node();
  this.root.prev = this.root;
  this.root.next = this.root;
  this.nodes = new Map();
};

/** 
 * @param {string} key
 * @return {void}
 */
AllOne.prototype.inc = function(key) {
  if(this.nodes.has(key)){
    const cur = this.nodes.get(key);
    const next = cur.next;
    if(next === this.root || cur.count + 1 < next.count){
      this.nodes.set(key, cur.insert(new Node(key, cur.count+1)));
    }else{
      next.keys.add(key);
      this.nodes.set(key, next);
    }
    if(cur.keys.size === 1){
      cur.remove();
    }else{
      cur.keys.delete(key);
    }
  }else{
    if(this.root.next === this.root || this.root.next.count > 1){
      this.nodes.set(key, this.root.insert(new Node(key, 1)))
    }else{
      this.nodes.set(key, this.root.next);
      this.root.next.keys.add(key)
    }
  }
};

/** 
 * @param {string} key
 * @return {void}
 */
AllOne.prototype.dec = function(key) {
  const cur = this.nodes.get(key);
  if(cur.count === 1){
    this.nodes.delete(key)
  }else{
    const prev = cur.prev;
    if(prev === this.root || prev.count+1 < cur.count){
      this.nodes.set(key, prev.insert(new Node(key, cur.count-1)));
    }else{
      prev.keys.add(key);
      this.nodes.set(key, prev);
    }
  }
  if(cur.keys.size === 1){
    cur.remove();
  }else{
    cur.keys.delete(key);
  }
};

/**
 * @return {string}
 */
AllOne.prototype.getMaxKey = function() {
  if(!this.root.prev){
    return "";
  }
  for(let maxKey of this.root.prev.keys){
    return maxKey;
  }
};

/**
 * @return {string}
 */
AllOne.prototype.getMinKey = function() {
  if(!this.root.next){
    return "";
  }
  for(let minKey of this.root.next.keys){
    return minKey;
  }
};

class Node{
  constructor(key, count){
    count ? this.count = count : 0;
    this.keys = new Set();
    key ? this.keys.add(key) : this.keys.add("");
  }

  insert(node){
    node.prev = this;
    node.next = this.next;
    node.prev.next = node;
    node.next.prev = node;
    return node;
  }

  remove(){
    this.prev.next = this.next;
    this.next.prev = this.prev;
  }
}
/**
 * Your AllOne object will be instantiated and called as such:
 * var obj = new AllOne()
 * obj.inc(key)
 * obj.dec(key)
 * var param_3 = obj.getMaxKey()
 * var param_4 = obj.getMinKey()
 */