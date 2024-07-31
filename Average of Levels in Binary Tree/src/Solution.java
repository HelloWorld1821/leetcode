import java.util.ArrayList;
import java.util.List;

public class Solution {

    //每一层的节点值之和
    private List<Double> sum = new ArrayList<>();
    //每一层的节点个数
    private List<Integer> count = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        else{
            traversal(root, 0);
            for (int i = 0; i < sum.size(); i++) {
                result.add(sum.get(i) / count.get(i));
            }
            return result;
        }
    }
    public void traversal(TreeNode node, int level) {
        if (node == null)
            return;
        //如果当前层还没有存储节点，则初始化该层的节点值
        if (sum.size() < level + 1)
            sum.add(level, (double) node.val);
        else
            sum.set(level, sum.get(level) + (double) node.val);
        //如果当前层还没有存储节点数，则初始化该层的节点数
        if (count.size() < level + 1)
            count.add(level, 1);
        else
            count.set(level, count.get(level) + 1);

        traversal(node.left, level + 1);
        traversal(node.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution s = new Solution();
        List<Double> result = s.averageOfLevels(root);
        for (double d : result) {
            System.out.print(d + " ");
        }
    }
}