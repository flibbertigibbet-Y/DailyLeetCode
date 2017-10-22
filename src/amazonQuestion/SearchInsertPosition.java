package amazonQuestion;

/**
 * Created by JiahengYu on 20/10/17.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return Math.max(end + 1, start - 1);
    }

    public static void main(String args[]) {
        int a[] = {1, 3};
        System.out.print(new SearchInsertPosition().searchInsert(a, 3));
    }
}
