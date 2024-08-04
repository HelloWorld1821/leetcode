public class Solution {
    public int singleNumber(int[] nums) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                int sum = 0;
                for (int j = 0; j < nums.length; j++) {
                    sum += (nums[j] >> i) & 1;
                }
                result |= (sum % 3) << i;
            }
            return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 1, 2, 1, 2, 3};
        int result = s.singleNumber(nums);
        System.out.println(result);
    }
}