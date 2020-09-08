import java.util.Arrays;

/**
 *322. 零钱兑换
 *https://leetcode-cn.com/problems/coin-change/
 */
public class Coinchange {

    static  int res = Integer.MAX_VALUE;

    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
//        _helper(coins, amount, 0);
        _helper(coins, amount, 0,coins.length-1);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    /**
     * coins不是倍数，执行失败
     * @param coins
     * @param amount
     * @param count
     * @param index
     */
    private static void _helper(int[] coins, int amount, int count,int index) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0) {
            return;
        }
        int coin = coins[index];
        int num = amount / coin;
        _helper(coins, amount - coin * num, count + num, index - 1);
    }

    /**
     * 超出时间限制
     * @param args
     */
//        private void _helper(int[] coins, int amount, int count) {
//        if (amount < 0) {
//            return;
//        }
//        if (amount == 0) {
//            res = Math.min(res, count);
//        }
//        for (int i = 0; i < coins.length; i++) {
//            _helper(coins, amount - coins[i], count + 1);
//        }
//    }

    public static void main(String[] args) {
        coinChange(new int[]{186,419,83,408}, 6249);
    }
}
