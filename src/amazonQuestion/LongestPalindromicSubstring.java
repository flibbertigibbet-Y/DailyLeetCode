package amazonQuestion;

/**
 * Created by JiahengYu on 29/09/17.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return s;
        int length = s.length();
        boolean dp[][] = new boolean[length][length];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = true;

        String result = s.substring(0, 1);
        int longest = 1;

        for (int len = 2; len <= s.length(); len++) {
            for (int start = 0; start <= s.length() - len; start++) {
                int end = start + len - 1;
                if (len == 2) {
                    if (s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = true;
                        if (longest < len) {
                            longest = 2;
                            result = s.substring(start, end + 1);
                        }
                    }
                } else {
                    if (dp[start + 1][end - 1] && s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = true;
                        if (longest < len) {
                            longest = len;
                            result = s.substring(start, end + 1);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.print(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}
