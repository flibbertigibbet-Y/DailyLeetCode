package amazonQuestion;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode moveA = headA;
        ListNode moveB = headB;

        int lengthA = 0;
        int lengthB = 0;

        while (moveA != null) {
            lengthA++;
            moveA = moveA.next;
        }

        while (moveB != null) {
            lengthB++;
            moveB = moveB.next;
        }

        moveA = headA;
        moveB = headB;

        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                moveA = moveA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                moveB = moveB.next;
            }
        }

        while (moveA != null && moveB != null) {
            if (moveA.val == moveB.val)
                return moveA;
            moveA = moveA.next;
            moveB = moveB.next;
        }
        return null;
    }

    public static void main(String args[]){
        ListNode A = new ListNode(1);
        ListNode B = A;

        System.out.print(new IntersectionofTwoLinkedLists().getIntersectionNode(A, B));
    }
}
