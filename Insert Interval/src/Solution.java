import java.util.Arrays;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        int index = 0;
        int len = intervals.length;
        if (len == 0) {
            result[index++] = newInterval;
            return Arrays.copyOf(result, index);
        }
        boolean inserted = false;
        for (int i = 0; i < len; i++) {
            //如果当前区间的右端点小于等于新区间的左端点，或者新区间已经插入，则直接添加当前区间
            if (intervals[i][1] < newInterval[0] || inserted) {
                result[index++] = intervals[i];
            }
            //如果当前区间的左端点大于等于新区间的右端点，则插入新区间
            else if (intervals[i][0] > newInterval[1] && !inserted) {
                result[index++] = newInterval;
                result[index++] = intervals[i];
                inserted = true;
            }
            //如果当前区间的左端点小于等于新区间的左端点，右端点大于等于新区间的右端点，则合并成一个区间
            else {
                if (!inserted){
                    newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                    newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                }
            }
        }
        //如果新区间没有插入，则添加到最后
        if (!inserted) {
            result[index] = newInterval;
            index++;
        }
        return Arrays.copyOf(result, index);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {{2,5},{6,7},{8,9}};
        int[] newInterval = {0,1};
        int[][] result = s.insert(intervals, newInterval);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}