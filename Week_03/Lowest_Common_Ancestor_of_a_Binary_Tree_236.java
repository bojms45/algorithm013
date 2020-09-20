package Recursion;
import java.util.*;
public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }
/**
 *      DFS, 三种判断，p 为 ancestor, q 为 ancestor, 他们两个有公用的ancestor
 *      Time: O(N)
 *      Space: O(N)
 * */


    public TreeNode bfs(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        map.put(root, null);
        queue.offer(root);

        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
                map.put(node.left, node);
            }
            if (node.right != null) {
                queue.offer(node.right);
                map.put(node.right, node);
            }
        }

        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }

        while (!set.contains(q))
            q = map.get(q);

        return q;
    }
/**
 *      BFS, 通过map，把每个node的parent一起放进去， 在通过set，求出q和p共同的parent
 *      Time: O(N)
 *      Space: O(N)
 * */
}
