import java.util.Stack;

/**
 * Created by JiahengYu on 28/09/17.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        int res = (l1.val + l2.val) / 10;
        ListNode pointer = result;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            ListNode current = new ListNode((res + l1.val + l2.val) % 10);
            res = (res + l1.val + l2.val) / 10;
            pointer.next = current;
            pointer = pointer.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode current = new ListNode((res + l1.val) % 10);
            res = (res + l1.val) / 10;
            pointer.next = current;
            pointer = pointer.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode current = new ListNode((res + l2.val) % 10);
            res = (res + l2.val) / 10;
            pointer.next = current;
            pointer = pointer.next;
            l2 = l2.next;
        }

        if (res>0){
            ListNode current = new ListNode(res);
            pointer.next = current;
        }

        return result;
    }

    public static void main(String args[]) {
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(6);
        ListNode six = new ListNode(4);
        one.next = two;
        two.next = three;

        four.next=five;
        five.next=six;
//        ListNode one = new ListNode(0);
//        ListNode two = new ListNode(0);

        ListNode result = new AddTwoNumbers().addTwoNumbers(one, four);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
