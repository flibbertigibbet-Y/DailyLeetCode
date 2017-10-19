package amazonQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 01/10/17.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<Integer>();
        if (rowIndex < 0)
            return result;
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        if (rowIndex == 1) {
            result.add(1);
            result.add(1);
            return result;
        }
        if (rowIndex == 2) {
            result.add(1);
            result.add(2);
            result.add(1);
            return result;
        }

        int one[] = new int[rowIndex + 1];
        int two[] = new int[rowIndex + 1];

        one[0] = 1;
        one[1] = 2;
        one[2] = 1;

        boolean isOddTurn = true;
        int currentRow = 2;
        while (currentRow < rowIndex) {
            if (isOddTurn) { //odd turn 用2
                two[0] = 1;
                int i = 0;
                for (i = 0; i < currentRow; i++) {
                    two[i + 1] = one[i] + one[i + 1];
                    one[i] = 0;
                }
                one[i] = 0;
                two[i + 1] = 1;
                isOddTurn = false;
            } else {
                one[0] = 1;
                int i = 0;
                for (i = 0; i < currentRow; i++) {
                    one[i + 1] = two[i] + two[i + 1];
                    two[i] = 0;
                }
                two[i] = 0;
                one[i + 1] = 1;
                isOddTurn = true;
            }
            currentRow++;
        }

        if (isOddTurn) {
            for (int a : one) {
                result.add(a);
            }
        } else {
            for (int a : two) {
                result.add(a);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.print(new PascalsTriangleII().getRow(6));
    }
}
