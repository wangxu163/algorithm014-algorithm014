public class Test3 {

    public static void main(String[] args) {
        myPow(2.0, 10);
    }

    public static double myPow(double x, int n) {
        long N = n;
        return N > 0 ? quickMul12(x, N) : 1.0 / quickMul12(x, -N);
    }

    private static double quickMul1(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul1(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    private static double quickMul12(double x, long N) {
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
