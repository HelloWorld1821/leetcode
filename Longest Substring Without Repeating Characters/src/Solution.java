import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        Set<Character> set = new HashSet<>();
        int max = 1;
        int left = 0;
        for (int right = 0; right < len; right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abcabcbb";
        int res = s.lengthOfLongestSubstring(str);
        System.out.println(res);
    }
}