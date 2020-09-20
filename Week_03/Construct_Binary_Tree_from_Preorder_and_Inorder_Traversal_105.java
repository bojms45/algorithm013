package BinaryTree;
import java.util.*;
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)    // O(N)
            map.put(inorder[i], i);

        return buildTree(preorder, inorder, 0, 0, inorder.length-1, map);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart >= preorder.length || inStart > inEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);
        int inIdx = map.get(preorder[preStart]);
        node.left = buildTree(preorder, inorder, preStart+1, inStart, inIdx-1, map);
        node.right = buildTree(preorder, inorder, preStart+inIdx-inStart+1, inIdx+1, inEnd, map);

        return node;
    }
/**
 *      通过preorder找出每个parent node。 通过这个parent node，在inorder找出其idx， 并且通过idx找出其左右subtree
 *      Time:   O(N), 其中 N 是树中的节点个数
 *      Space:  O(N), 除去返回的答案需要的 O(N) 空间之外，我们还需要使用 O(N) 的空间存储哈希映射，以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。这里 h < N，所以总空间复杂度为 O(N)。
 *
 * */
}
