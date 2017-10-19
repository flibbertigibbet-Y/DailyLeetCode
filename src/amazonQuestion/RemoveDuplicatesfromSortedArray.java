package amazonQuestion;

/**
 * Created by JiahengYu on 19/10/17.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int length = 1;
        int currentIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                length++;
                nums[currentIndex++] = nums[i];
            }
        }
        return length;
    }

    public static void main(String args[]) {
        int a[] = {1, 1, 2};
        System.out.print(new RemoveDuplicatesfromSortedArray().removeDuplicates(a));
    }
}
