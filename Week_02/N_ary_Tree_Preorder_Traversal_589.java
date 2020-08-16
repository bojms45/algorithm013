package BinaryTree;
import java.util.*;
public class N_ary_Tree_Preorder_Traversal_589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> helper(Node root, List<Integer> lst) {
        if (root == null) return lst;
        lst.add(root.val);
        for (Node child: root.children)
            helper(child, lst);
        return lst;
    }

    public List<Integer> sol_1(Node root) {
        List<Integer> lst = new ArrayList<>();
        return helper(root, lst);
    }
/**
 *      Recursive
 *      Time: O(N)
 *      Space: O(N)
 *
 * */

    public List<Integer> sol_2(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            lst.add(node.val);

            for (int i = node.children.size()-1; i >= 0; i--)
                stack.push(node.children.get(i));
        }
        return lst;
    }
/**
 *      Iterate, 调用Stack
 *      Time: O(N)
 *      Space: O(N)
 *
 * */
}
