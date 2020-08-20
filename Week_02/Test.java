import java.util.Stack;

public class Test {

    public  int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return len;
        }
        int ars = 0;
        for (int i = 0; i < len; i++) {
            int height = heights[i];
            int left = i;
            while (left > 0 && heights[left - 1] >= height) {
                left--;
            }
            int right = i;
            while (right < len - 1 && heights[right + 1] >= height) {
                right++;
            }
            ars = Math.max(ars, (right - left + 1) * height);
        }
        return ars;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        int i = largestRectangleArea2(arr);
        System.out.println("aaa");
    }
    public static   int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int ars = 0;
        for (int i = 0; i < n; i++) {
            ars = Math.max(ars, heights[i] * (right[i] - left[i] - 1));
        }
        return ars;
    }
}
