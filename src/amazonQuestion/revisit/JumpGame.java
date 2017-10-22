package amazonQuestion.revisit;

/**
 * Created by JiahengYu on 22/10/17.
 */
public class JumpGame {
    //2,3,1,1,4
    //1010
    //超时啦  不过思路应该是对的  就是记录每一步能不能到达 如果能到达 那么  从这步可以走到的最远的地方是哪儿
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return true;

        if (nums[0] == 0)
            return false;

        int accessible[] = new int[nums.length];
        accessible[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j <= i + nums[i]; j++) {
                if (j >= nums.length - 1 && accessible[i] == 1) {
                    return true;
                } else if (accessible[i] == 1) {
                    accessible[j] = 1;
                }
            }
        }
        return false;
    }

    //max记录的是当前能到达的最远的地方 如果下标大于了当前能到的最远地方 那么 直接返回false 因为当前点都没办法到达 那 肯定也没办法到达最后
    public boolean canJump2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }

    public static void main(String args[]) {
        int a[] = {3, 2, 1, 0, 4};
//        int a[] = {1,0,1,0};
//        int a[] = {2, 3, 1, 1, 4};
        System.out.print(new JumpGame().canJump(a));
    }
}
