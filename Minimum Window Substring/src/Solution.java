public class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        //统计一共有多少个不同的字符
        int charnum = 0;
        for (char c : t.toCharArray()) {
            count[c]++;
            if (count[c] == 1) {
                charnum++;
            }
        }
        //滑动窗口,formed表示当前窗口中有多少个字符满足和t中相同
        int left = 0, right = 0, formed = 0, start = 0, end = Integer.MAX_VALUE;
        while (right < s.length()) {
            //当不满足条件时,右指针不断右移
            while (formed < charnum && right < s.length()) {
                char c = s.charAt(right);
                count[c]--;
                //如果一个字符数量数量与t中相同,则formed加1
                if (count[c] == 0) {
                    formed++;
                }
                right++;
            }
            //当满足条件时,左指针不断左移,寻找最小窗口
            while (formed == charnum && left <= right) {
                //更新最小窗口
                if (right - left < end - start) {
                    start = left;
                    end = right;
                }
                char c = s.charAt(left);
                count[c]++;
                //如果一个字符数量差加1后等于1,则说明原来为0，移动后这个字符不再满足条件,formed减1
                if (count[c] == 1) {
                    formed--;
                }
                left++;
            }
        }
        return end == Integer.MAX_VALUE? "" : s.substring(start, end);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "aa";
        String t1 = "aa";
        String result = s.minWindow(s1, t1);
        System.out.println(result);
    }
}