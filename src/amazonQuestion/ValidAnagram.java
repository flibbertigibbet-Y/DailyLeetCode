package amazonQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 02/10/17.
 */
public class ValidAnagram {
//    public boolean isAnagram(String s, String t) {
//        if (s == null || t == null)
//            return false;
//        if (s.length() != t.length())
//            return false;
//        List<Character> characters = new LinkedList<Character>();
//        for (int i = 0; i < s.length(); i++) {
//            characters.add(s.charAt(i));
//        }
//
//        for (int i = 0; i < t.length(); i++) {
//            if (characters.contains(t.charAt(i))) {
//                characters.remove(new Character(t.charAt(i)));
//            } else
//                return false;
//        }
//        return true;
//    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;
        char[] tArray = t.toCharArray();
        quickSort(tArray, 0, tArray.length - 1);
        return new String(tArray).equals(s);
    }

    public void quickSort(char[] a, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            char x = a[i];
            while (i < j) {
                while (i < j && a[j] > x) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] < x) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);
        }
    }

//    int[] alphabet = new int[26];
//    for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
//    for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
//    for (int i : alphabet) if (i != 0) return false;
//    return true;

    public static void main(String args[]) {
        System.out.print(new ValidAnagram().isAnagram("a", "a"));
    }

}
