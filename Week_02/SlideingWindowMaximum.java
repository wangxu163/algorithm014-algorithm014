import java.util.Arrays;
import java.util.Stack;

public class SlideingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow1(arr, 3);
        ints = maxSlidingWindow2(arr, 3);
    }


    /**
     * 暴力求解
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int[] ret = new int[nums.length - k + 1];
        int a = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int[] arr = new int[k];
            int index = i;
            for (int j = 0; j < k; j++, index++) {
                arr[j] = nums[index];
            }
            Arrays.sort(arr);
            ret[a++] = arr[2];
        }
        return ret;
    }


    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int[] ret = new int[nums.length - k + 1];
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                if (stack.isEmpty() || nums[stack.peek()] < nums[i + j]) {
                    stack.push(i + j);
                }
            }
            ret[index++] = nums[stack.peek()];
            while (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return ret;
    }
}
