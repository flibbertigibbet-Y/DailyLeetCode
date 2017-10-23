package amazonQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 23/10/17.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> numberList = new ArrayList<Integer>();

        for (int a : nums) {
            numberList.add(a);
        }

        permutation(numberList, new LinkedList<Integer>(), result);

        return result;
    }

    public void permutation(List<Integer> numberList, List<Integer> currentPermutation, List<List<Integer>> result) {
        if (numberList.size() == 0) {
            result.add(currentPermutation);
            return;
        }

        for (int a : numberList) {
            List<Integer> copyCurrentPermute = new LinkedList<Integer>();
            copyCurrentPermute.addAll(currentPermutation);
            copyCurrentPermute.add(a);
            List<Integer> copyNumberList = new LinkedList<Integer>();
            copyNumberList.addAll(numberList);
            copyNumberList.remove(new Integer(a));
            permutation(copyNumberList, copyCurrentPermute, result);
        }
    }

    public static void main(String args[]) {
        int a[] = {1, 2, 3};
        System.out.print(new Permutations().permute(a));
    }
}
