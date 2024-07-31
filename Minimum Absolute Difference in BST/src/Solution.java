import java.util.Stack;

public class Solution {
    private TreeNode prev = null;
    private int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inorderTraversal(root);
        return minDiff;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);

        if (prev!= null) {
            int diff = Math.abs(root.val - prev.val);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        prev = root;

        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        Solution s = new Solution();
        System.out.println(s.getMinimumDifference(root));
    }
}