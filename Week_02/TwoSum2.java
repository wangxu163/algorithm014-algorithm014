import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * two-sum
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum2 {


    /**
     * 暴力求解
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    /**
     * 两遍hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int content = target - nums[i];
            if (map.containsKey(content) && map.get(content) != i) {
                return new int[]{i, map.get(content)};
            }
        }
        return new int[]{};
    }
    /**
     * 一遍hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int content = target - nums[i];
                if (map.containsKey(content) && map.get(content) != i) {
                    return new int[]{i, map.get(content)};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
    }

}