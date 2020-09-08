
/**
 *322. 零钱兑换
 *https://leetcode-cn.com/problems/coin-change/
 */
public class Coinchange {

    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        _helper(coins, amount, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void _helper(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }
        for (int i = 0; i < coins.length; i++) {
            _helper(coins, amount - coins[i], count + 1);
        }
    }


}
