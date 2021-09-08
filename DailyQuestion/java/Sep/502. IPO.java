class Solution {
  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
      int len = profits.length;
      int[][] arr = new int[len][2];
      int cur = 0;
      for(int i=0; i<len; i++){
          arr[i][0] = capital[i];
          arr[i][1] = profits[i];
      }
      Arrays.sort(arr, (a, b)->a[0] - b[0]);
      PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)->y-x);
      for(int i=0; i<k; i++){
          while (cur < len && arr[cur][0] <= w){
              pq.offer(arr[cur][1]);
              cur++;
          }
          if(pq.isEmpty()){
              break;
          }
          w += pq.poll();
      }
      return w;
  }
}