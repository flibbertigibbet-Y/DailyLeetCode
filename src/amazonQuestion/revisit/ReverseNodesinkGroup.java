package amazonQuestion.revisit;

/**
 * Created by JiahengYu on 19/10/17.
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0 || k == 1)
            return head;
        ListNode move = head;
        for (int i = 0; i < k; i++) {
            if (move == null)
                return head;
            else
                move = move.next;
        }
        ListNode newHead = reverKNode(head, k - 1);
        head.next = reverseKGroup(move, k);
        return newHead;
    }

    public ListNode reverKNode(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        ListNode next = head.next;
        ListNode newHead = reverKNode(next, k - 1);
        next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String args[]) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
//        five.next = six;

        ListNode result = new ReverseNodesinkGroup().reverseKGroup(one, 3);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
