import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by JiahengYu on 29/09/17.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return null;
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length())
                    return -1;
                else if (o1.length() == o2.length())
                    return 0;
                else
                    return 1;
            }
        });

        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].startsWith(result)) {
                continue;
            } else {
                int index = 0;
                while (index < Math.min(result.length(), strs[i].length()) && result.charAt(index) == strs[i].charAt(index)) {
                    index++;
                }
                if (index >= result.length()) {
                    continue;
                } else {
                    result = result.substring(0, index);
                }
            }
        }
        return result;
    }


    public static void main(String args[]) {
        String a[] = {"c", "acc", "ccc"};
        System.out.print(new LongestCommonPrefix().longestCommonPrefix(a));
    }
}
