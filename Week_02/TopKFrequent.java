import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] arr = {4,1,-1,2,-1,2,3};
        int[] ints = topKFrequent(arr, 2);
        System.out.println("aaa");
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key:map.keySet()){
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.poll();
                queue.add(key);
            }
        }
        int size = queue.size();
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = queue.poll();
        }
       return ret;
    }
}
