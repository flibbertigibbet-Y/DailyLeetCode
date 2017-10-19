package amazonQuestion;

/**
 * Created by JiahengYu on 03/10/17.
 */


//        [
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],
//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
//        ]
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int col = matrix[0].length;
        int row = matrix.length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1])
            return false;

        int i = 0;
        int j = col - 1;

        while (true) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target) {
                i++;
                if (i >= row)
                    return false;
            } else {
                j--;
                if (j < 0) {
                    return false;
                }
            }
        }
    }

    public static void main(String args[]) {
        int a[][] = {{-1, 3}};
        System.out.print(new Searcha2DMatrixII().searchMatrix(a, 1));
    }
}
