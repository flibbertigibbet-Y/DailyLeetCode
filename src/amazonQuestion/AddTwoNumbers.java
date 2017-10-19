package amazonQuestion;

/**
 * Created by JiahengYu on 29/09/17.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode result = null;
        ListNode move = null;
        int res = 0;
        while (l1 != null && l2 != null) {
            if (result == null) {
                result = new ListNode((l1.val + l2.val + res) % 10);
                move = result;
            } else {
                move.next = new ListNode((l1.val + l2.val + res) % 10);
                move = move.next;
            }
            res = (l1.val + l2.val + res) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            move.next = new ListNode((l1.val + res) % 10);
            move = move.next;
            res = (l1.val + res) / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            move.next = new ListNode((l2.val + res) % 10);
            move = move.next;
            res = (l2.val + res) / 10;
            l2 = l2.next;
        }

        if (res > 0) {
            move.next = new ListNode(res);
        }

        return result;
    }
}
