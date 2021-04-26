class Solution {
  public int shipWithinDays(int[] weights, int D) {
    // 确定二分查找左右边界
    //最小运载能力必须等于数组最大值，再低运不动；最大运载能力数组所有数之和，再高就浪费资源了
    int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
    while (left < right) {
        int mid = (left + right) / 2;
        // need 为需要运送的天数
        // cur 为当前这一天已经运送的包裹重量之和
        int need = 1, cur = 0;
        for (int weight : weights) {
            if (cur + weight > mid) {
                ++need;
                cur = 0;
            }
            cur += weight;
        }
        //need 小于等于D，mid运载力高了可以往左取更小运载力。
        if (need <= D) {
            right = mid;
        } else {//need大于D，mid运载力不够，需要往右边取更大的运载力
            left = mid + 1;
        }
    }
    return left;
  }
}
