package BinaryTree;
import java.util.*;
public class N_ary_Tree_Postorder_Traversal_590 {
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

    List<Integer> lst = new ArrayList<>();
    public List<Integer> sol_1(Node root) {
        if (root == null) return new ArrayList<>();
        for (Node child: root.children)
            sol_1(child);
        lst.add(root.val);
        return lst;
    }
/**
 *      Recursive
 *      Time: O(N)
 *      Space: O(N)
 * */

    public List<Integer> helper(Node root, List<Integer> lst) {
        if (root == null) return lst;
        for (Node child: root.children)
            helper(child, lst);

        lst.add(root.val);
        return lst;
    }

    public List<Integer> sol_2(Node root) {
        List<Integer> lst = new ArrayList<>();
        return helper(root, lst);
    }
/**
 *      Recursive: Non-global variable
 *      Time: O(N)
 *      Space: O(N)
 * */

    public List<Integer> iterate(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            lst.add(node.val);

            for (Node child: node.children)
                stack.push(child);
        }
        Collections.reverse(lst);

        return lst;
    }
/**
 *      Iterate, 调用stack，最后reverse list
 *      Time: O(N)
 *      Space: O(N)
 * */
}
