public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs1(1));
        System.out.println(climbStairs1(2));
        System.out.println(climbStairs1(3));
        System.out.println(climbStairs1(4));
        System.out.println(climbStairs1(5));
    }


    public static int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        for (int i = 3; i < n + 1; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
