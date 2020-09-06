import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses2 {

    public List<String> generateParenthesis(int n) {
        List<String> solutions = new ArrayList<>();
        if (n == 0) {
            return solutions;
        }
        dfs("", 0, 0, n, solutions);
        return solutions;
    }

    /**
     * dfs
     *
     * @param curStr
     * @param left
     * @param right
     * @param n
     * @param solutions
     */
    private void dfs(String curStr, int left, int right, int n, List<String> solutions) {
        if (left == n && right == n) {
            solutions.add(curStr);
            return;
        }

        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, solutions);
        }

        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, solutions);
        }
    }

    static class Node {
        private String res;//得到的字符串
        private int left;//剩余左括号数量
        private int right;//剩余右括号数量

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * bfs
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.right> curNode.left) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }

}