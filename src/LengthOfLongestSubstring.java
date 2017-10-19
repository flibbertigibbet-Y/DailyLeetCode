import java.util.HashSet;
import java.util.Set;

/**
 * Created by JiahengYu on 28/09/17.
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int maxLength = 1;
        Set<Character> set = new HashSet<Character>();
        int first = 0;
        set.add(s.charAt(first));
        for (int second = first + 1; second < s.length(); second++) {
            char currentOne = s.charAt(second);
            if (set.contains(currentOne)) {
                maxLength = maxLength >= (second - first) ? maxLength : (second - first);
                while (set.contains(currentOne) && first < second) {
                    set.remove(s.charAt(first));
                    first++;
                }
            }
            set.add(currentOne);
        }
        return maxLength > s.length() - first ? maxLength : s.length() - first;
    }

    public static void main(String args[]) {
        String one = "au";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(one));
    }
}
