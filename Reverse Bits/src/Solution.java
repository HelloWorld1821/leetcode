public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            //提取n最后一位并放入result的最低位
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 43261596;
        int result = s.reverseBits(n);
        System.out.println(result);
        if (result == 964176192) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
    }
}