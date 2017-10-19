package amazonQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<Integer>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        if (n == 1) {
            result.add(0);
            result.add(1);
            return result;
        }

        List<String> template = new ArrayList<String>();
        template.add("0");
        template.add("1");

        for (int i = 2; i <= n; i++) {
            List<String> temp = new LinkedList<String>();
            for (int j = 0; j < template.size(); j++) {
                temp.add("0" + template.get(j));
            }
            for (int j = template.size() - 1; j >= 0; j--) {
                temp.add("1" + template.get(j));
            }
            template = temp;
        }

        for (String s : template) {
            result.add(greyToInt(s));
        }

        return result;

    }

    public int greyToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result += Math.pow(2, s.length() - 1 - i);
            }
        }
        return result;
    }


    public static void main(String args[]) {
        System.out.print(new GrayCode().grayCode(2));
    }
}
