import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeStock {

    private int res ;

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    /**
     * @param prices 股价数组
     * @param index  当前是第几天，从 0 开始
     * @param status 0 表示不持有股票，1表示持有股票，
     * @param profit 当前收益
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {
        if (index == len) {
            this.res = Math.max(this.res, profit);
            return;
        }
        dfs(prices, index + 1, len, status, profit);
        if (status == 0) {
            dfs(prices, index + 1, len, 1, profit - prices[index]);
        }else {
            dfs(prices, index + 1, len, 0, profit + prices[index]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        BestTimeStock bestTimeStock = new BestTimeStock();
        bestTimeStock.maxProfit(arr);
    }


    public int maxProfit2(int[] prices) {
        int res = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
