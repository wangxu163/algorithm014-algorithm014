import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * two-sum
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum2 {

    public static void main(String[] args) {
        int[] arr = {2, 4, 7};
        int[] ints = twoSum4(arr, 6);
    }

    /**
     * 暴力求解
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
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
    public static int[] twoSum2(int[] nums, int target) {
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
    public static int[] twoSum3(int[] nums, int target) {
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

    /**
     * 两头夹逼法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum4(int[] nums, int target) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int x = 0;
        int y = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length;) {
            if (nums[i] + nums[j] == target) {
                x = nums[i];
                y = nums[j];
                break;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            }
        }
        int a = -1;
        int b = -1;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == x && a == -1) {
                a = i;
            }else if (ints[i] == y && b == -1) {
                b = i;
            }
        }
        return a == -1 || b == -1 ? new int[]{} : new int[]{a, b};
    }

}