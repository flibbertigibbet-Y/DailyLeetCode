package amazonQuestion;

/**
 * Created by JiahengYu on 30/09/17.
 */
public class TrappingRainWater {
    //[0,1,0,2,1,0,1,3,2,1,2,1]
    //以单个位置来看， 他能困住多少水，取决于他左边的min（他左边的虽大高度和 右边的最大高度）
    //这是一个动态规划， 一个bar左边最高 要么等于 bar左边的那个bar的左边最高 或者bar左边的那个bar 所以 是一个dp问题

//    public int trap(int[] height) {
//        if (height == null || height.length < 3) {
//            return 0;
//        }
//        int container[] = new int[height.length];
//        int max = 0;
//
//        for (int i = 0; i < height.length; i++) {
//            container[i] = max;
//            max = Math.max(max, height[i]);
//        }
//
//        max = 0;
//        int result = 0;
//        for (int i = height.length - 1; i >= 0; i--) {
//            container[i] = Math.min(max, container[i]);
//            max = Math.max(max, height[i]);
//            result += Math.max(0, container[i] - height[i]);
//        }
//
//        return result;
//    }

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        //找到左边第一个峰值
        while (left < right && height[left] <= height[left + 1]) left++;
        while (left < right && height[right] <= height[right - 1]) right--;

        while (left < right) {
            int leftValue = height[left];
            int rightValue = height[right];

            if (leftValue < rightValue) {
                while (left < right && leftValue >= height[++left]) {
                    sum += leftValue - height[left];
                }
            } else {
                while (left < right && rightValue >= height[--right]) {
                    sum += rightValue - height[right];
                }
            }
        }

        return sum;
    }

    public static void main(String args[]) {
//        int water[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int water[] = {5,4,1,2};
//        int water[] = {4, 2, 3};
        int water[] = {2, 0, 2};
        System.out.print(new TrappingRainWater().trap(water));
    }

}
