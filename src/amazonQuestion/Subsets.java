package amazonQuestion;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 30/09/17.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        result.add(new LinkedList<Integer>());
        if (nums.length == 0)
            return result;
        List<Integer> number = new LinkedList<Integer>();
        for (int a : nums) {
            number.add(a);
        }
        for (int i = 1; i <= nums.length; i++) {
            sub(number, i, new LinkedList<Integer>(), result);
        }
        return result;
    }

    public void sub(List<Integer> nums, int length, List<Integer> current, List<List<Integer>> result) {
        if (length == 0) {
            result.add(current);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> copy = new LinkedList<Integer>(current);
            copy.add(nums.get(i));
            List<Integer> copyNums = new ArrayList<Integer>();
            for (int j = i + 1; j < nums.size(); j++) {
                copyNums.add(nums.get(j));
            }
            sub(copyNums, length - 1, copy, result);
        }
    }

    public static void main(String args[]) {
        int a[] = {1, 2, 3};
        List<List<Integer>> result = new Subsets().subsets(a);
        System.out.print(result);
    }

}
