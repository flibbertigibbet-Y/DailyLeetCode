package amazonQuestion;

/**
 * Created by JiahengYu on 22/10/17.
 */
public class QuickSort {
    public void quickSort(int left, int right, int[] candidate) {
        if (left < right) {
            int l = left;
            int r = right;
            int x = candidate[l];
            while (l < r) {
                while (l < r && candidate[r] > x) {
                    r--;
                }
                if (l < r) {
                    candidate[l++] = candidate[r];
                }
                while (l < r && candidate[l] < x) {
                    l++;
                }
                if (l < r) {
                    candidate[r--] = candidate[l];
                }
            }
            candidate[l] = x;
            quickSort(left, l - 1, candidate);
            quickSort(l + 1, right, candidate);
        }
    }
}
