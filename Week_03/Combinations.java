import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> solutions = new LinkedList<>();
        _helper(solutions, new LinkedList<>(), 1,n, k);
        return solutions;
    }

    private void _helper(List<List<Integer>> solutions, LinkedList<Integer> curr, int first, int n, int k) {
        //teminator
        if (curr.size() == k) {
            solutions.add(new LinkedList<>(curr));
            return;
        }
        //process
        //drill down
        //reverse
        for (int i = first; i < n + 1; i++) {
            curr.add(i);
            _helper(solutions, curr, i + 1, n, k);
            curr.removeLast();
        }
    }


}
