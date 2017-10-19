package amazonQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 29/09/17.
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        if (digits == null || digits.length()==0)
            return result;
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combination(result, "", map, digits);
        return result;
    }

    public void combination(List<String> result, String currentString, String[] map, String digits) {
        if (digits.length()==0) {
            result.add(currentString);
            return;
        }
        int number = Integer.parseInt(digits.charAt(0) + "");
        for (int i = 0; i < map[number - 2].length(); i++) {
            combination(result, currentString + map[number - 2].charAt(i), map, digits.substring(1, digits.length()));
        }
    }

    public static void main(String args[]) {
        List<String> result = new LetterCombinationsofaPhoneNumber().letterCombinations("23");
        for (String s : result)
            System.out.println(s);
    }
}
