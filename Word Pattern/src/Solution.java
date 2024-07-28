import java.util.Map;
import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length!= pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            //如果存在健，且值不等于当前单词，说明有冲突的字符到单词的映射
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) {
                    return false;
                }
            }

            //如果不存在健但是值存在，说明有冲突的单词到字符的映射
            else {
                if (map.containsValue(word)) {
                    return false;
                }
                map.put(c, word);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String pattern = "abba";
        String s1 = "dog cat cat dog";
        boolean res = s.wordPattern(pattern, s1);
        if (res) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}