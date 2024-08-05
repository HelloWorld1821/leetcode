public class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] <= 9) {
                return digits;
            }

            else if (digits[i] > 9 && i > 0) {
                digits[i] = 0;
                digits[i - 1]++;
            }
        }

        int[] result = new int[digits.length + 1];
        System.arraycopy(digits, 0, result, 1, digits.length);
        result[1] = 0;
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] digits = {9, 9, 9};
        int[] result = s.plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}