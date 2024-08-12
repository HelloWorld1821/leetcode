import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int count = s.findMinArrowShots(points);
        System.out.println(count);
    }
}