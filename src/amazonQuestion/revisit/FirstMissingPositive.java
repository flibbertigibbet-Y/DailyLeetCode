package amazonQuestion.revisit;

/**
 * Created by JiahengYu on 22/10/17.
 */
public class FirstMissingPositive {
    //因为是找第一个丢失的正数， 所以一定是从1开始的
    //如果把1放在0的位置 把2放在一的位置 这样都搞定了以后 重新扫描 不符合的 就是第一个差的
    //根据题意 missing的可能不止一个  我们只要找第一个
    //我记得这个题 和那个  哪个桶的金子缺斤少两的题是一样的思路
    public int firstMissingPositive(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            // 如果a[start] = 5  那么 5应该放到a[4]上， 但是 如果a[4]上已经是5了 那么 就没必要交换了
            if (nums[start] == start + 1 || nums[start] <= 0 || nums[start] > nums.length || nums[start] == nums[nums[start] - 1])
                start++;
            else swap(start, nums[start] - 1, nums);
        }
        start = 0;
        while (start < nums.length && nums[start] == start + 1) {
            start++;
        }
        return start+1;
    }

    public void swap(int i, int j, int a[]) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
