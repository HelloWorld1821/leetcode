public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        //保留xor中最低位的1来区分两个数
        int diff = xor & -xor;
        int[] result = new int[2];
        for (int num : nums) {
            //放进第一组
            if ((num & diff) == 0) {
                result[0] ^= num;
            }
            //放进第二组
            else {
                result[1] ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = s.singleNumber(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}