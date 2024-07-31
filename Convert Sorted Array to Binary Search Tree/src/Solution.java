import java.util.Arrays;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Solution s = new Solution();
        TreeNode root = s.sortedArrayToBST(nums);
        System.out.println(root.val);
        if (root.left!= null)
            System.out.println(root.left.val);
        if (root.right!= null)
            System.out.println(root.right.val);
        if (root.left != null && root.left.left != null)
            System.out.println(root.left.left.val);
        if (root.left != null && root.left.right != null)
            System.out.println(root.left.right.val);
        if (root.right != null && root.right.left != null)
            System.out.println(root.right.left.val);
        if (root.right != null && root.right.right != null)
            System.out.println(root.right.right.val);
    }
}