package amazonQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 22/10/17.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (candidates == null || candidates.length == 0)
            return result;
        calculation(target, 0, candidates, new LinkedList<Integer>(), result);
        return result;
    }

    public void calculation(int target, int start, int[] candidtate, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(temp);
            return;
        }
        for (int i = start; i < candidtate.length; i++) {
            if (target - candidtate[i] >= 0) {
                List<Integer> tempCopy = new LinkedList<Integer>();
                tempCopy.addAll(temp);
                tempCopy.add(candidtate[i]);
                calculation(target - candidtate[i], i, candidtate, tempCopy, result);
            }
        }
    }

    public static void main(String args[]) {
        int a[] = {2, 3, 6, 7};
        System.out.print(new CombinationSum().combinationSum(a, 7));
    }
}
