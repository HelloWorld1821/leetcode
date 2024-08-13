public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //复制节点，并将新节点插入到原节点之后
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        //复制random指针
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //拆分链表
        curr = head;
        Node newHead = curr.next;
        Node newCurr = newHead;
        while (curr != null) {
            curr.next = curr.next.next;
            if (curr.next != null) {
                newCurr.next = newCurr.next.next;
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head.next;
        head.next.next.next.random = head.next.next;

        Solution s = new Solution();
        Node newHead = s.copyRandomList(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}