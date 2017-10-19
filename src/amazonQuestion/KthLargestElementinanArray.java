package amazonQuestion;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class KthLargestElementinanArray {
//    public int findKthLargest(int[] nums, int k) {
//        quickSort(nums, 0, nums.length - 1);
//        return nums[nums.length - k];
//    }

    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int temp = quickSort(nums, l, r);
            if (temp == nums.length-k) {
                return nums[temp];
            } else if (temp > nums.length-k) {
                r = temp - 1;
            } else {
                l = temp + 1;
            }
        }
        return nums[nums.length-k];
    }


    public int quickSort(int[] nums, int l, int r) {
        int i = l;
        int j = r;
        int x = nums[i];
        while (i < j) {
            //快速排序 一定是从后往前
            while (i < j && nums[j] > x) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < x) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = x;
        return i;
    }


//    public void quickSort(int[] nums, int l, int r) {
//        if (l < r) {
//            int i = l;
//            int j = r;
//            int x = nums[i];
//            while (i < j) {
//                //快速排序 一定是从后往前
//                while (i < j && nums[j] > x) {
//                    j--;
//                }
//                if (i < j) {
//                    nums[i++] = nums[j];
//                }
//                while (i < j && nums[i] < x) {
//                    i++;
//                }
//                if (i < j) {
//                    nums[j--] = nums[i];
//                }
//            }
//            nums[i] = x;
//            quickSort(nums, l, i - 1);
//            quickSort(nums, i + 1, r);
//        }
//    }

    public static void main(String arg[]) {
        int a[] = {3, 2, 1, 5, 6, 4};
        int b = new KthLargestElementinanArray().findKthLargest(a, 2);
        System.out.print(b);
    }
}
