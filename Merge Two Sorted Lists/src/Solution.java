public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        while (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }

        while (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Solution s = new Solution();
        ListNode merged = s.mergeTwoLists(l1, l2);
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}