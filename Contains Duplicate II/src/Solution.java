import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //如果集合中已经有k个元素，则移除最早的元素
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            //如果当前元素已经存在于集合中，则返回true
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean res = s.containsNearbyDuplicate(nums, k);
        if (res) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}