/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 */
public class Pow {

    public static double myPow(double x, int n) {
        long N = n;
        return N > 0 ? quickMul1(x, N) : 1.0 / quickMul1(x, -N);

    }

    /**
     *  递归
     * @param x
     * @param N
     * @return
     */
    private static double quickMul1(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul1(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 迭代
     * @param x
     * @param N
     * @return
     */
    private static double quickMul2(double x, long N) {
        double ans = 1.0;
        double mul = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= mul;
            }
            mul *= mul;
            N /= 2;
        }
        return ans;
    }

}
