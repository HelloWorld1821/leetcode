public class Solution {
    public String addBinary(String a, String b) {
        String answer = new String();
        int sum = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            answer = (char)('0' + sum % 2) + answer;
            sum /= 2;
        }
        if (sum > 0) {
            answer = (char)('0' + sum) + answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "11";
        String b = "1";
        s.addBinary(a, b);
        System.out.println(s.addBinary(a, b));
    }
}