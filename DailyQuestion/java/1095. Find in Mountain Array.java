package DailyQuestion.java;
interface MountainArray {
    public int get(int index);
    public int length();
}
class MountainArrayImpl implements MountainArray{
    private int[] arr;
    private int len;
    public MountainArrayImpl(int[] arr){
        this.arr = arr;
        this.len = arr.length;
    }
    @Override
    public int get(int index) {
        if(index < 0 || index >= len){
            throw new RuntimeException();
        }
        return this.arr[index];
    }

    @Override
    public int length() {
        return this.len;
    }
}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int topIndex = findMountainTop(mountainArr, 0, len-1);
        int res = findMountainLeft(mountainArr, 0, topIndex, target);
        return res == -1 ? findMountainRight(mountainArr, topIndex, len-1, target) : res;
    }
    private int findMountainTop(MountainArray mountainArray,int l, int r){
        while (l < r){
            int mid = l + ((r-l)>>1);
            if(mountainArray.get(mid) < mountainArray.get(mid+1)){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }
    private int findMountainLeft(MountainArray mountainArray, int l, int r, int target){
        while (l <= r){
            int mid = l + ((r - l)>>1);
            int midNum = mountainArray.get(mid);
            if(midNum == target){
                return mid;
            }else if(midNum > target){
                r = mid - 1;
            }else {
                l = mid+1;
            }
        }
        return -1;
    }
    private int findMountainRight(MountainArray mountainArray, int l, int r, int target){
        while (l <= r){
            int mid = l + ((r - l)>>1);
            int midNum = mountainArray.get(mid);
            if(midNum == target){
                return mid;
            }else if(midNum < target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
}