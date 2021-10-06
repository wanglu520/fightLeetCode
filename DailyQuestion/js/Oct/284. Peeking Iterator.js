class PeekingIterator {
  constructor(nums = []){
    this.nums = nums;
    this.length = nums.length;
    this.curIndex = 0;//当前指针所在位置
  }
  next(){
    const res = this.peek();
    this.curIndex++;
    return res;
  }
  peek(){
    return this.curIndex >= this.length ? 
                                    undefined : 
                                    this.nums[this.curIndex];
  }
  hasNext(){
    return this.curIndex < this.length;
  }
}