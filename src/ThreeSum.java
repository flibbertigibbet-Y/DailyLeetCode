import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 29/09/17.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; ) {
            int j = i + 1;
            int k = nums.length - 1;
            int target = 0 - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j - 1]);
                    do {
                        k--;
                    } while (j < k && nums[k] == nums[k + 1]);
                } else if (nums[j] + nums[k] > target) {
                    k--;
                }else {
                    j++;
                }
            }
            do {
                i++;
            }while (i< nums.length - 2 && nums[i] == nums[i-1]);
        }
        return res;
    }

    public void quickSort(int[] s, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] > x) {
                    j--;
                }
                if (i < j) {
                    s[i++] = s[j];
                }
                while (i < j && s[i] < x) {
                    i++;
                }
                if (i < j) {
                    s[j--] = s[i];
                }
            }
            s[i] = x;
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }

    public static void main(String args[]) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new ThreeSum().threeSum(a);
        System.out.print("here");
    }
}
