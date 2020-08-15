public class SwapInParis {


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
//        swapPairs1(listNode1);
        ListNode listNode = swapPairs2(listNode1);
        System.out.println("aaa");
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 遍历方式
     * @param head
     * @return
     */
    public static ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prev = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }

    /**
     * 递归方式
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs2(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }
}
