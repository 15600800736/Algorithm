package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fdh on 2017/9/28.
 */


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
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

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        Interval interval1 = new Interval();
        interval1.start = 1;
        interval1.end = 4;
    }
}
