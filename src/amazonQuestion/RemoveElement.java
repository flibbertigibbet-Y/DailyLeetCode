package amazonQuestion;

/**
 * Created by JiahengYu on 19/10/17.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        while (index < nums.length && nums[index] != val) {
            index++;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String args[]) {
        int a[] = {3, 2, 2, 3};
        System.out.print(new RemoveElement().removeElement(a, 3));
    }
}
