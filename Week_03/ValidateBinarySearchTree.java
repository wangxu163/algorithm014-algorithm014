/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {


    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * 递归
     * @param root
     * @param lower
     * @param upeer
     * @return
     */
    private boolean helper(TreeNode root, Integer lower, Integer upeer) {
        if (root == null) {
            return  true;
        }
        int val = root.val;
        if (lower != null && val <= lower) {
            return  false;
        }
        if (upeer != null && val >= upeer) {
            return  false;
        }
        if (!helper(root.right, val, upeer)) {
            return false;
        }
        if (!helper(root.left, lower, val)) {
            return false;
        }
        return true;
    }
}
