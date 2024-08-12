import java.util.Comparator;

public class MyComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        if (a[0] < b[0]) {
            return -1;
        }
        else if (a[0] > b[0]){
            return 1;
        }
        else {
            return 0;
        }
    }
}
