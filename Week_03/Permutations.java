import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    public static   List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        int[] visited = new int[nums.length];
        _helper(solutions, nums, new ArrayList<Integer>(), visited);
        return solutions;
    }

    private static  void _helper(List<List<Integer>> solutions, int[] nums, ArrayList<Integer> temps, int[] visited) {
        if (temps.size() == nums.length) {
            solutions.add(new ArrayList<>(temps));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            temps.add(nums[i]);
            _helper(solutions, nums, temps, visited);
            visited[i] = 0;
            temps.remove(temps.size() - 1);
        }
    }


}
