/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 84. 柱状图中最大的矩形
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        int i = largestRectangleArea1(arr);
        i = largestRectangleArea2(arr);
        System.out.println("aaa");
    }


    /**
     * 暴力求解 遍历高度，然后向两端遍历获取宽度
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            int height =  heights[i];
            int left = i;
            while (left > 0 && heights[left - 1] >= height) {
                left--;
            }
            int right = i;
            while (right < len - 1 && heights[right + 1] >= height) {
                right++;
            }
            int width = right - left + 1;
            res = Math.max(res, width * height);
        }
        return res;
    }

    /**
     * stack
     * @param heights
     * @return
     */
    public static int largestRectangleArea2(int[] heights) {

        return 0;
    }

}
