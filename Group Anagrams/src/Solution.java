import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        for (String str : strs) {
            if (map.containsKey(str)) {
                continue;
            }
            List<String> group = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                if (isAnagram(str, strs[i])) {
                    group.add(strs[i]);
                    map.put(strs[i], 1);
                }
            }
            result.add(group);
        }
        return result;
    }

    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : str1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = s.groupAnagrams(strs);
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}