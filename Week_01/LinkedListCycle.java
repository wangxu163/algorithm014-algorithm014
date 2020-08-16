import java.util.*;

public class LinkedListCycle {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode3;
        boolean b = hasCycle1(listNode1);
        b = hasCycle2(listNode1);
        System.out.println(b);
    }
    

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * hash
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> sets = new HashSet<>();
        while (head != null) {
            if (sets.contains(head)) {
                return true;
            }
            sets.add(head);
            head = head.next;
        }
        return  false;
    }

    /**
     * 双指针
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
