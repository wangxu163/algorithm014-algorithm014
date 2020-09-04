import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    /**
     * 递归
     * @param ans
     * @param nums
     * @param list
     * @param index
     */
    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        dfs(ans,nums,list,index+1);
        list.add(nums[index]);
        dfs(ans,nums,list,index+1);
        list.remove(list.size() - 1);
    }

    /**
     * 迭代
     * @param nums
     * @return
     */
    private List<List<Integer>> dfs2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> subs = new ArrayList<>();
            for (List<Integer> item : ans) {
                List<Integer> newItem = new ArrayList<>();
                newItem.addAll(item);
                newItem.add(num);
                subs.add(newItem);
            }
            ans.addAll(subs);
        }
        return ans;
    }
}
