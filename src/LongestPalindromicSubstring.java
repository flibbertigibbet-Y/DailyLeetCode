/**
 * Created by JiahengYu on 28/09/17.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int length = s.length();

        int longest = 1;
        String longestPalindrome = s.substring(0, 1);

        int d[][] = new int[length][length];

        for (int i = 0; i < length; i++) {
            d[i][i] = 1;
        }

        for (int len = 2; len <= length; len++) {
            for (int start = 0; start <= length - len; start++) {
                int end = start + len - 1;
                if (end - start == 1) {
                    if (s.charAt(start) == s.charAt(end)) {
                        d[start][end] = 1;
                        if (longest < len) {
                            longest = len;
                            longestPalindrome = s.substring(start, end + 1);
                        }
                    }
                } else {
                    if (d[start + 1][end - 1] == 1 && s.charAt(start) == s.charAt(end)) {
                        d[start][end] = 1;
                        if (longest < len) {
                            longest = len;
                            longestPalindrome = s.substring(start, end + 1);
                        }
                    }
                }
            }
        }
        return longestPalindrome;
    }

    public static void main(String args[]) {
        System.out.print(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}
