public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        //虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //反转部分的前驱节点
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        //当前处理的节点
        ListNode curr = prev.next;
        //当前节点的下一个节点
        ListNode next;
        //每次将当前节点的下一个节点插入到前驱节点之后的位置，实现后来者居上
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int left = 2;
        int right = 4;
        ListNode result = s.reverseBetween(head, left, right);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}