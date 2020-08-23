import java.util.ArrayList;
import java.util.List;

public class BinaryTreeOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     *  二叉树中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        inhelper(root,list);
        return list;
    }

    /**
     *  二叉树前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        prehelper(root,list);
        return list;
    }

    /**
     *  二叉树后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        posthelper(root,list);
        return list;
    }

    public void inhelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inhelper(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inhelper(root.right, list);
        }
    }
    public void prehelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            prehelper(root.left, list);
        }
        if (root.right != null) {
            prehelper(root.right, list);
        }
    }
    public void posthelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            posthelper(root.left, list);
        }
        if (root.right != null) {
            posthelper(root.right, list);
        }
        list.add(root.val);
    }
}

