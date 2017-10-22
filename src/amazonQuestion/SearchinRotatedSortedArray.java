package amazonQuestion;

//4 5 6 7 0 1 2
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
            int istart = 0, iend = nums.length-1, mid;
            while(istart <= iend)
            {
                mid = (istart + iend) / 2;
                if(nums[mid] > target)
                {
                    if(nums[iend] < nums[istart] && target <= nums[iend] && nums[mid] > nums[iend])
                        istart = mid + 1;
                    else iend = mid - 1;
                }
                else if(nums[mid] < target)
                {
                    if(nums[iend] < nums[istart] && target > nums[iend] && nums[mid] < nums[iend])
                        iend = mid - 1;
                    else istart = mid + 1;
                }
                else return mid;
            }
            return -1;

    }

    public static void main(String args[]) {
        int a[] = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.print(new SearchinRotatedSortedArray().search(a, 8));
    }
}
