package amazonQuestion;

/**
 * Created by JiahengYu on 02/10/17.
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];

        result[0] = 1;
        int a = 1;
        for (int i = 1; i < nums.length; i++) {
            a *= nums[i - 1];
            result[i] = a;
        }
        a = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            a *= nums[i + 1];
            result[i] = result[i] * a;
        }
        return result;
    }

    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4};
        int rest[] = new ProductofArrayExceptSelf().productExceptSelf(a);
        for (int b: rest){
            System.out.println(b);
        }
    }
}
