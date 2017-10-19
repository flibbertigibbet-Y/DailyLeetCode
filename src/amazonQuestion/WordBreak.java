package amazonQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return false;
        boolean[] flag = new boolean[s.length()+1];
        flag[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (flag[j] && wordDict.contains(s.substring(j, i))){
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }

    public static void main(String args[]){
        List<String> dic = new LinkedList<String>();
        dic.add("leet");
        dic.add("code");
        String arg = "leetcode";

        System.out.print(new WordBreak().wordBreak(arg, dic));
    }
}
