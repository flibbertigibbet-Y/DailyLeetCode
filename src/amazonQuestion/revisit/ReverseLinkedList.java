package amazonQuestion.revisit;

import amazonQuestion.revisit.ListNode;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
