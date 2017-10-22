package amazonQuestion;

/**
 * Created by JiahengYu on 20/10/17.
 */
public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int first = binarySearch(0, nums.length - 1, target, nums);
        if (first == -1)
            return result;
        else {
            result[0] = first;
            result[1] = first;
            while (true) {
                int tempOne = binarySearch(0, result[0] - 1, target, nums);
                if (tempOne == -1 || tempOne == result[0]||nums[result[0]-1]!=target)
                    break;
                else result[0] = tempOne;
            }
            while (true) {
                int tempOne = binarySearch(result[1] + 1, nums.length - 1, target, nums);
                if (tempOne == -1 || tempOne == result[1] || nums[result[1]+1]!=target)
                    break;
                else
                    result[1] = tempOne;
            }
        }
        return result;
    }

    int binarySearch(int start, int end, int target, int[] nums) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int a[] = {5, 7, 7, 8, 8, 10};
        int[] result = new SearchforaRange().searchRange(a, 8);
        System.out.print(result[0] + "," + result[1]);
    }
}
