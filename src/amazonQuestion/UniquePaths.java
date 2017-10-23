package amazonQuestion;

/**
 * Created by JiahengYu on 23/10/17.
 */
public class UniquePaths {
    //超时
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 1;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public static void main(String args[]) {
        System.out.print(new UniquePaths().uniquePaths(23, 12));
    }
}
