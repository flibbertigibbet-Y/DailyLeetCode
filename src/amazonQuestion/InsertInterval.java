package amazonQuestion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 23/10/17.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        if (newInterval == null) {
            return intervals;
        }

        int i = 0;
        for (i = 0; i < intervals.size(); i++) {
            if (newInterval.start <= intervals.get(i).start) {
                intervals.add(i, newInterval);
                break;
            }
        }
        if (i >= intervals.size()) {
            intervals.add(newInterval);
        }

        Interval currentInterval = intervals.get(0);

        for (int j = 1; j < intervals.size(); j++) {
            if (intervals.get(j).start <= currentInterval.end) {
                currentInterval = new Interval(currentInterval.start, Math.max(currentInterval.end, intervals.get(j).end));
            } else {
                result.add(currentInterval);
                currentInterval = intervals.get(j);
            }
        }

        result.add(currentInterval);
        return result;
    }

    public static void main(String args[]) {
        List<Interval> list = new LinkedList<Interval>();
        list.add(new Interval(1, 5));
//        list.add(new Interval(6, 9));
        System.out.print(new InsertInterval().insert(list, new Interval(2, 7)));
    }
}
