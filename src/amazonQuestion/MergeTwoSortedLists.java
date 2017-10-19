package amazonQuestion;

/**
 * Created by JiahengYu on 29/09/17.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode result = null;
        ListNode move = null;
        if (l1.val > l2.val) {
            result = l2;
            move = result;
            l2 = l2.next;
        } else {
            result = l1;
            move = result;
            l1 = l1.next;
        }
        while (l1 != null && l2 != null) {
            ListNode current = null;
            if (l1.val > l2.val) {
                current = l2;
                l2 = l2.next;
            } else {
                current = l1;
                l1 = l1.next;
            }
            move.next = current;
            move = move.next;
        }

        if (l1 != null) {
            move.next = l1;
        }

        if (l2 != null) {
            move.next = l2;
        }

        return result;
    }

    public static void main(String args[]) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(7);
        ListNode five = new ListNode(2);
        ListNode six = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        five.next = six;

        ListNode result = new MergeTwoSortedLists().mergeTwoLists(one, five);

        System.out.print("here");
    }

}
