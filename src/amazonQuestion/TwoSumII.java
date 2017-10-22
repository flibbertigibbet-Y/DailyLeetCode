package amazonQuestion;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];

        int first = 0;
        int second = numbers.length - 1;

        while (first < second) {
            if (numbers[first] + numbers[second] == target) {
                result[0] = first + 1;
                result[1] = second + 1;
                return result;
            } else if (numbers[first] + numbers[second] > target) {
                second--;
            } else {
                first++;
            }
        }
        return result;
    }
}
