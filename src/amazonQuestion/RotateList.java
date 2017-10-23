package amazonQuestion;

/**
 * Created by JiahengYu on 23/10/17.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;

        int i = 0;
        int length = 1;

        ListNode move = head;
        while (move != null) {
            length++;
            move = move.next;
        }

        if (k == length)
            return head;

        if (k > length) {
            k = k % length;
            if (k == 0)
                return head;
        }


        while (fast.next != null) {
            if (i >= k) {
                slow = slow.next;
            }
            i++;
            fast = fast.next;
        }


        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }

    public static void main(String args[]) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next = two;
        two.next = three;

        ListNode result = new RotateList().rotateRight(one, 1);

        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
