import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前、中、后序遍历
 */
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

    /**
     * 中序遍历 栈
     * @param root
     * @return
     */
    public List <Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
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

