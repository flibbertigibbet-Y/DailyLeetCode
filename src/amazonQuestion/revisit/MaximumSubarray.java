package amazonQuestion.revisit;

/**
 * Created by JiahengYu on 22/10/17.
 */
public class MaximumSubarray {
//    太慢啦
//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return 0;
//        int[][] dp = new int[nums.length][nums.length];
//        int result = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            dp[i][i] = nums[i];
//            result = Math.max(result, dp[i][i]);
//        }
//
//        for (int distance = 1; distance <= nums.length - 1; distance++) {
//            for (int start = 0; start < nums.length - distance; start++) {
//                int end = start + distance;
//                dp[start][end] = dp[start][end - 1] + nums[end];
//                result = Math.max(result, dp[start][end]);
//            }
//        }
//
//        return result;
//    }

    //如果没变大  就不要merge前面的

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] + nums[i] > nums[i]) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String args[]) {
//        int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int a[] = {1, 2};
        System.out.print(new MaximumSubarray().maxSubArray(a));
    }
}
