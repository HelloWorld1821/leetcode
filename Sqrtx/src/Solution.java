public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1, right = 1;
        //估计右边界
        while (right < x / right) {
            right *= 10;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            }
            else if (mid < x / mid) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int x = 8;
        int result = s.mySqrt(x);
        System.out.println(result);
    }
}