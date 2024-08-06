public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int minLen = s.minSubArrayLen(target, nums);
        System.out.println(minLen);
    }
}