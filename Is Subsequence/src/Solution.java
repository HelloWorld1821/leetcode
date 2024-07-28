public class Solution {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        if (i == len1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abc";
        String t = "ahbgdc";
        if (solution.isSubsequence(s, t)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}