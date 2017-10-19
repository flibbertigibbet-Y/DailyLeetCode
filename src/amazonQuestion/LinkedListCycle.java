package amazonQuestion;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode one = head;
        ListNode two = head;

        while (two.next != null && two.next.next != null) {
            two = two.next.next;
            one = one.next;
            if (two == one)
                return true;
        }
        return false;
    }
}
