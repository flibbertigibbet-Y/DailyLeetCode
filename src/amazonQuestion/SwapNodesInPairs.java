package amazonQuestion;

/**
 * Created by JiahengYu on 19/10/17.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        head.next = swapPairs(head.next);
        return next;
    }
}
