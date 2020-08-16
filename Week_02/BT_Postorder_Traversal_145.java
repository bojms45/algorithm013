package BinaryTree;
import java.util.*;

public class BT_Postorder_Traversal_145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void helper(TreeNode root, List<Integer> lst) {
        if (root == null) return;
        helper(root.left, lst);
        helper(root.right, lst);
        lst.add(root.val);
    }

    public List<Integer> sol_1(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        helper(root, lst);
        return lst;
    }
/**
 *      Recursive
 *      Time: O(N)
 *      Space: O(N)
 * */
    public List<Integer> sol_2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            lst.add(0, node.val);

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return lst;
    }
/**
 *      Iterate, 调用stack
 *      Time: O(N)
 *      Space: O(N)
 * */
}
