import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapmax = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            map.put(nums[i], nums[i]);
            mapmax.put(nums[i], nums[i]);
            set.add(nums[i]);
        }
        //至少有一个元素连续
        int maxlen = 1;
        for (int num : set) {
            if (map.get(num) == num)
            {
                while (map.containsKey(num + 1)) {
                    num++;
                    map.put(num, map.get(num - 1));
                    mapmax.put(map.get(num - 1), Math.max(mapmax.getOrDefault(map.get(num - 1), 0), num));
                    maxlen = Math.max(maxlen, mapmax.get(num) - map.get(num) + 1);
                }
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -3, -3, 7, -3, 0, 5, 0, -8, -4, -1, 2};
        Solution s = new Solution();
        int result = s.longestConsecutive(nums);
        System.out.println(result);
    }
}