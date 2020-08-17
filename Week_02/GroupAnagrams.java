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
    public static List<List<String>> groupAnagrams1(String[] strs) {
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

    /**
     * 计数
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length <= 0) {
            return Collections.EMPTY_LIST;
        }
        Map<String, List> ans = new HashMap<>();
        int[] counter = new int[26];
        for (String str : strs) {
           Arrays.fill(counter,0);
           for (char c: str.toCharArray()){
               counter[c - 'a']++;
           }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#").append(counter[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }
}
