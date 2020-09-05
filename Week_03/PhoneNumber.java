import java.util.*;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class PhoneNumber {

    public static void main(String[] args) {
        letterCombinations("23");
    }

    public static List<String> letterCombinations(String digits) {
        if (null == digits || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character , String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new LinkedList<>();
        search("", digits,0, res, map);
        return res;
    }

    private static void search(String s, String digits, int level,
                        List<String> res, Map<Character, String> map) {
        //1 terminator
        if (level == digits.length()) {
            res.add(s);
            return;
        }
        //2 process
        String letters = map.get(digits.charAt(level));
        //3 drill down
        for (int i = 0; i < letters.length(); i++) {
            search(s+letters.charAt(i),digits,level+1,res,map);
        }
        //4 reverse

    }
}
