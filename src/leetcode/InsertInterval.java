package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fdh on 2017/9/28.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        List<Interval> result = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        intervals.sort(Comparator.comparingInt(i -> i.start));
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = new Interval();
            interval.start = intervals.get(i).start;
            boolean canMerge = true;
            int max = 0;
            while (canMerge && i < intervals.size()) {
                int end = intervals.get(i).end;
                max = Math.max(max, end);
                if (i < intervals.size() - 1) {
                    int start = intervals.get(i + 1).start;
                    if (start > max) {
                        interval.end = max;
                        result.add(interval);
                        canMerge = false;
                    } else {
                        i++;
                    }
                } else {
                    interval.end = max;
                    result.add(interval);
                    return result;
                }
            }
        }
        return result;
    }
}
