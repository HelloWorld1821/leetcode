import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        //如果数组为空，直接返回空列表
        if (nums.length == 0) {
            return result;
        }
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                //如果只有一个元素，直接添加到结果中
                if (start == i - 1) {
                    result.add(Integer.toString(nums[start]));
                }
                //如果有多个元素
                else {
                    result.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[i - 1]));
                }
                start = i;
            }
        }
        //最后一个元素不连续
        if (start == nums.length - 1) {
            result.add(Integer.toString(nums[start]));
        }
        //最后一个元素连续
        else {
            result.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[nums.length - 1]));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        Solution s = new Solution();
        List<String> result = s.summaryRanges(nums);
        System.out.println(result);
    }
}