package amazonQuestion;

/**
 * Created by JiahengYu on 30/09/17.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row + 1; col < matrix.length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        int limit = matrix.length % 2 == 0 ? matrix.length / 2 : (matrix.length - 1) / 2;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < limit; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix.length-1-col];
                matrix[row][matrix.length-1-col] = temp;
            }
        }
        return;
    }
}
