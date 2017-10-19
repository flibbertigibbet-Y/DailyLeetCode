package amazonQuestion;

import java.util.Stack;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class NumberofIslands {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int result = 0;

        boolean visit[][] = new boolean[grid.length][grid[0].length];

        Stack<Point> stack = new Stack<Point>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    if (visit[i][j]) {
                        continue;
                    } else {
                        result++;
                        stack.push(new Point(i, j));
                        while (!stack.isEmpty()) {
                            Point current = stack.pop();
                            int m = current.x;
                            int n = current.y;
                            if (m + 1 < grid.length && grid[m + 1][n] == '1' && visit[m + 1][n] != true) {
                                stack.push(new Point(m + 1, n));
                                visit[m + 1][n] = true;
                            }
                            if (m - 1 >= 0 && grid[m - 1][n] == '1' && visit[m - 1][n] != true) {
                                stack.push(new Point(m - 1, n));
                                visit[m - 1][n] = true;
                            }
                            if (n + 1 < grid[0].length && grid[m][n + 1] == '1' && visit[m][n + 1] != true) {
                                stack.push(new Point(m, n + 1));
                                visit[m][n + 1] = true;
                            }
                            if (n - 1 >= 0 && grid[m][n - 1] == '1' && visit[m][n - 1] != true) {
                                stack.push(new Point(m, n - 1));
                                visit[m][n - 1] = true;
                            }
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
//        char a[][]={
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'},
//        };
        char a[][] = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'},
        };

        System.out.print(new NumberofIslands().numIslands(a));
    }
}
