import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//        示例:
//        给定 nums = [2, 7, 11, 15], target = 9
//        因为 nums[0] + nums[1] = 2 + 7 = 9
//        所以返回 [0, 1]
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2,2};
        int target = 4;
        int[] ints = twoSum1(arr, target);
        PrintUtils.print(ints);
        int[] ints2 = twoSum2(arr, target);
        PrintUtils.print(ints2);
        int[] ints3 = twoSum3(arr, target);
        PrintUtils.print(ints3);
        int[] ints4 = twoSum4(arr, target);
        PrintUtils.print(ints4);
    }


    /**
     * 暴力求解
     * 时间复杂度 O(n^2) 遍历两次
     * 空间复杂度 O(1) 无额外
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
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
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * 如果出现重复元素会导致同一下表出现两次，因为hashmap 同一个key覆盖
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; ) {
            int temp = nums[i] + nums[j];
            if (temp == target) {
                return new int[]{map.get(nums[i]), map.get(nums[j])};
            } else if (temp > target) {
                int i1 = nums[i] < nums[j] ? j-- : i++;
            } else if (temp < target) {
                int i1 = nums[i] < nums[j] ? i++ : j--;
            }
        }
        return new int[]{};
    }


    /**
     * 两遍hash表
     * target-nums[i]的值在hash表中是否存在
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
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
     * 一遍hash表
     * target-nums[i]的值在hash表中是否存在
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum4(int[] nums, int target) {
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
