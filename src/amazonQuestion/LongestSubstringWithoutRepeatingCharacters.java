package amazonQuestion;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JiahengYu on 29/09/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        if (s.length() <= 1)
            return s.length();
        int result = 1;
        int left = 0;
        int right = left + 1;
        Set<Character> set = new HashSet<Character>();
        set.add(s.charAt(left));
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                result = Math.max(result, right - left);
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }

            }
            set.add(s.charAt(right));
            right++;
        }
        return Math.max(result, right - left);
    }
}
