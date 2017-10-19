package amazonQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        if (head.next == null && head.random == null)
            return new RandomListNode(head.label);
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode move = head;
        while (move != null) {
            map.put(move, new RandomListNode(move.label));
            move = move.next;
        }
        move = head;
        RandomListNode copyHead = map.get(move);
        RandomListNode copyMove = copyHead;
        while (move != null) {
            copyMove.next = map.get(move.next);
            copyMove.random = map.get(move.random);
            copyMove = copyMove.next;
            move = move.next;
        }

        return copyHead;
    }
}
