package BinaryTree;
import java.util.*;
public class BT_Inorder_Traversal_94 {
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

    List<Integer> lst = new ArrayList<>();
    public List<Integer> sol_1(TreeNode root) {
        if (root == null) return lst;
        sol_1(root.left);
        lst.add(root.val);
        sol_1(root.right);
        return lst;
    }
/**
 *      Recursive， arrayList是全局变量
 *      Time: O(N)
 *      Space: O(N)
 * */

    public void helper(TreeNode root, List<Integer> lst) {
        if (root == null) return;
        helper(root.left, lst);
        lst.add(root.val);
        helper(root.right, lst);
    }

    public List<Integer> sol_2(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        helper(root, lst);
        return lst;
    }
/**
 *      Recursive，建立helper的method，使list变为local variable
 *      Time: O(N)
 *      Space: O(N)
 * */

    public List<Integer> iterate(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            lst.add(cur.val);
            cur = cur.right;
        }
        return lst;
    }
/**
 *      Iterate, 调用stack
 *      Time: O(N)
 *      Space: O(N)
 * */


}
