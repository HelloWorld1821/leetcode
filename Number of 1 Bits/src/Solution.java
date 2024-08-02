public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1)
                count++;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 11;
        int result = s.hammingWeight(n);
        System.out.println(result);
    }
}