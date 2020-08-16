package BinaryTree;
import java.util.*;

public class N_ary_Tree_Level_Order_Traversal_429 {
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


    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> lst = new ArrayList<>();

            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                lst.add(node.val);

                for (Node child: node.children)
                    q.offer(child);
            }

            res.add(lst);
        }

        return res;
    }
/**
 *      BFS， 按层次遍历tree， 把每一层的node单独加入到一个list中
 *      Time: O(N)
 *      Space: O(N)
 * */
}
