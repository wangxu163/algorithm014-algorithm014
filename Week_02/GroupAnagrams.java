import java.util.*;

/**
 * 49 字母异味词分组
 * group-anagrams
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {


    /**
     * 排序
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length <= 0) {
            return Collections.EMPTY_LIST;
        }
        Map<String, List> ans = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }
}
