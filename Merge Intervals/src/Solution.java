import java.util.Arrays;

public class Solution {
    public int[][] merge(int[][] intervals) {
        //按起始位置排序
        //MyComparator cmp = new MyComparator();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int len = intervals.length;
        int[][] res = new int[len][2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (index == 0 || intervals[i][0] > res[index - 1][1]) {
                res[index++] = intervals[i];
            }
            else {
                res[index - 1][1] = Math.max(intervals[i][1], res[index - 1][1]);
            }
        }
        return Arrays.copyOf(res, index);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution s = new Solution();
        int[][] res = s.merge(intervals);
        for (int[] interval : res) {
            System.out.println(Arrays.toString(interval));
        }
    }
}