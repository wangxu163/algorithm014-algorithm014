import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {


    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {

//        _generate(0, 2 * n, "");
        _generate1(0, 0, 3, "");

        return null;
    }

    private static void _generate1(int left, int right, int n, String s) {
        if (left == n && right == n) {
            System.out.println(s);
            return;
        }
        if (left < n) {
            _generate1(left + 1, right, n, s + "(");
        }
        if (left > right) {
            _generate1(left, right + 1, n, s + ")");
        }
    }

    private static void _generate(int level, int max, String s) {
        if (level >= max) {
            System.out.println(s);
            return;
        }
        _generate(level + 1, max, s + "(");
        _generate(level + 1, max, s + ")");
    }

}
