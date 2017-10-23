package amazonQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 23/10/17.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return result;
        if (intervals.size() == 1)
            return intervals;
        Interval[] array = new Interval[intervals.size()];
        int i = 0;
        for (Interval a : intervals) {
            array[i] = a;
            i++;
        }

        quickSort(0, intervals.size() - 1, array);
        Interval current = array[0];

        for (int j = 1; j < array.length; j++) {
            if (array[j].start <= current.end) {
                current = new Interval(current.start, Math.max(current.end, array[j].end));
            } else {
                result.add(current);
                current = array[j];
            }
        }

        result.add(current);

        return result;
    }

    public void quickSort(int start, int end, Interval[] intervals) {
        if (start < end) {
            int l = start;
            int r = end;
            Interval x = intervals[l];
            while (l < r) {
                while (l < r && intervals[r].start > x.start) {
                    r--;
                }
                if (l < r) {
                    intervals[l++] = intervals[r];
                }
                while (l < r && intervals[l].start < x.start) {
                    l++;
                }
                if (l < r) {
                    intervals[r--] = intervals[l];
                }
            }
            intervals[l] = x;
            quickSort(start, l - 1, intervals);
            quickSort(l + 1, end, intervals);
        }
    }
}
