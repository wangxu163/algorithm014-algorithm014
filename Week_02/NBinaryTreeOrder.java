import java.util.*;

/**
 * n叉树的前、中、后序遍历
 */
public class NBinaryTreeOrder {

    static class Node {
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
    }

    /**
     * n叉树的后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
            List<Integer> list = new ArrayList<>();
            postorderhelper(root, list);
            return list;
    }

    private void postorderhelper(Node root, List<Integer> list) {
        if (null == root) {
            return;
        }
        for (Node node : root.children) {
            postorderhelper(node,list);
        }
        list.add(root.val);
    }

    /**
     * n叉树的前序遍历
     * @param root
     * @return
     */
    public List<Integer> pretorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorderhelper(root, list);
        return list;
    }
    private void preorderhelper(Node root, List<Integer> list) {
        if (null == root) {
            return;
        }
        list.add(root.val);
        for (Node node : root.children) {
            preorderhelper(node,list);
        }
    }


    /**
     * n叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelorder(Node root) {
        List<List<Integer>> all = new ArrayList<>();
        if (null == root) {
            return all;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll.val);
                queue.addAll(poll.children);
            }
            all.add(list);
        }
        return all;
    }


}
