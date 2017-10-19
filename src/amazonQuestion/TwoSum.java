package amazonQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JiahengYu on 29/09/17.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target- nums[i]);
                result[1] = i;
                return  result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
