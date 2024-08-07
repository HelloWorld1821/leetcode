import java.util.*;

public class Solution {
    /*
    //以下实现需要频繁删除和维护哈希表，效率较低
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, String> wordSet = new HashMap<>();
        //存储每个已经在窗口中出现过的单词的序号来判断是否全部出现过
        Set<Integer> checkedSet = new HashSet<>();
        //将词典中的单词存入哈希表，并记录每个单词的序号
        int number = 0;
        for (String word : words) {
            wordSet.put(number, word);
            number++;
        }
        //保存单词映射的副本，因为每次查询都会删除对应的映射，即getKeyByValue方法中的remove
        Map<Integer, String> wordSetcopy = new HashMap<>(wordSet);
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int wordLen = words[0].length();
        int wordnum = words.length;
        int sLen = s.length();
        //遍历滑动窗口
        for (int i = 0; i < sLen - wordLen * wordnum + 1; i++) {
            //检查字符串是否包含词典中所有单词的检查位置
            int j = i;
            //滑动窗口中字符串包含词典中单词的个数
            int k = 0;
            checkedSet.clear();
            while (j < i + wordLen * wordnum && k < wordnum) {
                String word = s.substring(j, j + wordLen);
                //判断当前单词是否在词典中
                int num = getKeyByValue(wordSet, word);
                if (num >= 0 && num < number && !checkedSet.contains(num)) {
                    checkedSet.add(num);
                    k++;
                }
                else {
                    break;
                }
                j += wordLen;
                if (k == wordnum) {
                    result.add(i);
                }
            }
            wordSet.putAll(wordSetcopy);
        }
        return result;
    }

    public static int getKeyByValue(Map<Integer, String> map, String value) {
        Iterator<Map.Entry<Integer, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, String> entry = iter.next();
            if (value.equals(entry.getValue())) {
                //找到第一个匹配的key
                int key = entry.getKey();
                //因为词典中可能有重复的单词，所以需要将重复的单词都删除掉
                iter.remove();
                return key;
            }
        }
        return (int)1e9;
    }
    */

    //以下实现外层循环是对滑动窗口的起始位置进行遍历，这样可以避免重复计算
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        Map<String, Integer> diff = new HashMap<>();
        int wordlen = words[0].length();
        int wordnum = words.length;
        int slen = s.length();
        //遍历滑动窗口的起始位置
        for (int i = 0; i < wordlen && i + wordlen * wordnum <= slen; i++) {
            //初始化diff
            diff.clear();
            for (String word: words) {
                diff.put(word, diff.getOrDefault(word, 0) + 1);
            }
            for (int j = i; j <= wordlen * wordnum + i - 1; j += wordlen) {
                String sub = s.substring(j, j + wordlen);
                diff.put(sub, diff.getOrDefault(sub, 0) - 1);
                if (diff.get(sub) == 0) {
                    diff.remove(sub);
                }
            }
            if (diff.isEmpty()) {
                result.add(i);
            }
            //滑动窗口向右移动
            for (int start = i + wordlen; start <= slen - wordlen * wordnum; start += wordlen) {
                String sub = s.substring(start + wordlen * (wordnum - 1), start + wordlen * wordnum);
                diff.put(sub, diff.getOrDefault(sub, 0) - 1);
                if (diff.get(sub) == 0) {
                    diff.remove(sub);
                }
                sub = s.substring(start - wordlen, start);
                diff.put(sub, diff.getOrDefault(sub, 0) + 1);
                if (diff.get(sub) == 0) {
                    diff.remove(sub);
                }
                if (diff.isEmpty()) {
                    result.add(start);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words1 = {"fooo", "barr", "wing", "ding", "wing"};
        List<Integer> result1 = s.findSubstring(s1, words1);
        System.out.println(result1);
    }
}