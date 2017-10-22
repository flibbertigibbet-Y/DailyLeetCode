package amazonQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 22/10/17.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (candidates == null || candidates.length == 0)
            return result;
        quickSort(0, candidates.length - 1, candidates);
        combiantions(target, candidates, 0, new LinkedList<Integer>(), result);
        return result;
    }

    public void combiantions(int target, int[] candidate, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            if (!result.contains(current))
                result.add(current);
            return;
        }
        for (int i = start; i < candidate.length; ) {
            if (target - candidate[i] >= 0) {
                List<Integer> copyCurrent = new LinkedList<Integer>();
                copyCurrent.addAll(current);
                copyCurrent.add(candidate[i]);
                combiantions(target - candidate[i], candidate, i + 1, copyCurrent, result);
            }
            do {
                i++;
            } while (i < candidate.length && candidate[i] == candidate[i - 1]);
        }
    }

    public void quickSort(int left, int right, int[] candidate) {
        if (left < right) {
            int l = left;
            int r = right;
            int x = candidate[l];
            while (l < r) {
                while (l < r && candidate[r] > x) {
                    r--;
                }
                if (l < r) {
                    candidate[l++] = candidate[r];
                }
                while (l < r && candidate[l] < x) {
                    l++;
                }
                if (l < r) {
                    candidate[r--] = candidate[l];
                }
            }
            candidate[l] = x;
            quickSort(left, l - 1, candidate);
            quickSort(l + 1, right, candidate);
        }
    }

    public static void main(String args[]) {
        int a[] = {10, 1, 2, 7, 6, 1, 5};
        System.out.print(new CombinationSumII().combinationSum2(a, 8));
    }
}
