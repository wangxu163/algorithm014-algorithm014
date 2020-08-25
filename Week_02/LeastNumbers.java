import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class LeastNumbers {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int[] leastNumbers = getLeastNumbers(arr, 2);
        System.out.println("aaa");
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        Queue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (priorityQueue.peek() > arr[i]) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }


    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        if (k == arr.length) {
            return arr;
        }
        Queue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i = 0; i < arr.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(arr[i]);
            }else if (priorityQueue.peek() > arr[i]) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }
}
