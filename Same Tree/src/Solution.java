public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        //有一棵树的节点为空，另一棵树的节点不为空，则返回false
        if (p == null || q == null) {
            return false;
        }
        //两棵树的根节点值不同，则返回false
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(5);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        q.left.right = new TreeNode(5);

        Solution s = new Solution();
        if (s.isSameTree(p, q)) {
            System.out.println("The two trees are the same");
        }
        else {
            System.out.println("The two trees are not the same");
        }
    }
}