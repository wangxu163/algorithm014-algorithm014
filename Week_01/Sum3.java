import java.util.*;

public class Sum3 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists1 = threeSum1(arr);
        List<List<Integer>> lists2 = threeSum2(arr);
        List<List<Integer>> lists3 = threeSum3(arr);
        System.out.println("aaa");
    }

    /**
     * 暴力求解法，三重循环，时间复杂度O(n^3)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> list = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[k]);
                        list.add(integers);
                    }
                }
            }
        }
        return new ArrayList<>(list);
    }


    /**
     * hash 时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> list = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>(nums.length-1);
            for (int j = i + 1; j < nums.length; j++) {
                int value = target - nums[j];
                Integer exist = map.get(value);
                if (exist != null) {
                    List<Integer> integers = Arrays.asList(nums[i], nums[j], exist);
                    integers.sort(Comparator.naturalOrder());
                    list.add(integers);
                }else {
                    map.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(list);
    }

    /**
     * 双指针 时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (sum < 0) {
                    while (i<j && nums[i] == nums[++i]);
                }else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i<j && nums[i] == nums[++i]);
                    while (i<j && nums[j]==nums[--j]);
                }
            }
        }
        return list;
    }
}
