package amazonQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 30/09/17.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new LinkedList<String>());
            ans.get(key).add(s);
        }
        List<List<String>> result = new LinkedList<List<String>>(ans.values());
        return result;
    }

    public static void main(String args[]) {
        String a[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new GroupAnagrams().groupAnagrams(a);
        System.out.print(result);
    }
}
