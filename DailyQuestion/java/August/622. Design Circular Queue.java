class MyCircularQueue {
  private int start;
  private int end;
  private int length;
  private int[] elements;
  public MyCircularQueue(int k) {
      start = 0;
      end = 0;
      length = k + 1;
      elements = new int[length];
  }

  public boolean enQueue(int value) {
      if(isFull()){
          return false;
      }
      elements[end] = value;
      end = (end + 1) % length;
      return true;
  }

  public boolean deQueue() {
      if(isEmpty()){
          return false;
      }
      start = (start + 1) % length;
      return true;
  }

  public int Front() {
      if(isEmpty()){
          return -1;
      }
      return elements[start];
  }

  public int Rear() {
      if(isEmpty()){
          return -1;
      }
      return elements[end];
  }

  public boolean isEmpty() {
      return start == end;
  }

  public boolean isFull() {
      return ((end + 1) % length) == start;
  }
}