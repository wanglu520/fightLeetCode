package DailyQuestion.java.August;

class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
      long ugly = 0;
      Set<Long> seen = new HashSet<>();
      PriorityQueue<Long> queue = new PriorityQueue<>();//利用优先列队从小到大排序
      seen.add(1L);
      queue.offer(1L);
      for(int i=0; i<n; i++){
          ugly = queue.poll();
          for(int prime : primes){
              long temp = ugly * prime;
              if(seen.add(temp)){//去重
                  queue.offer(temp);
              }
          }
      }
      return (int)ugly;
  }
}