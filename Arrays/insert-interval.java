import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57 {

    public static void main(String[] args) {
        int[][] intervals = { {1,2}, {3, 5}, {6, 7}, {8, 10}, {12, 16} };
        int[] newInterval = {4, 8};

        int[][] result = new LC57().insert(intervals, newInterval);

        for(int[] r: result) {
            System.out.print(r[0] + " " + r[1]);
            System.out.println();
        }
    }

    private int findNewIntervalIndexBS(int[][] intervals, int toFindUpperBoundFor) {
        int resultIndex = intervals.length;

        int start = 0;
        int end = intervals.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(intervals[mid][0] > toFindUpperBoundFor) {
                resultIndex = mid;
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }

        return resultIndex;
    }

    private int[][] insertNewIntervalAtIndex(int[][] intervals, int[] newInterval, int index) {
        List<int []> intervalList = new ArrayList<>(Arrays.asList(intervals));

        if(index != intervals.length) {
            intervalList.add(index, newInterval);
        } else {
            intervalList.add(newInterval);
        }

        return intervalList.toArray(new int[intervalList.size()][2]);
    }

    private boolean doesIntervalsOverlap(int[] firstInterval, int[] secondInterval) {
        return ( Math.min(firstInterval[1], secondInterval[1]) - Math.max(firstInterval[0], secondInterval[0]) ) >= 0;
    }

    private int[] mergeInterval(int[] firstInterval, int[] secondInterval) {
        int[] mergedInterval = { Math.min(firstInterval[0], secondInterval[0]), Math.max(firstInterval[1], secondInterval[1])};
        return mergedInterval;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int indexToInsertNewIntervalAt = findNewIntervalIndexBS(intervals, newInterval[0]);
        // updated intervals array
        int[][] updatedIntervals = insertNewIntervalAtIndex(intervals, newInterval, indexToInsertNewIntervalAt);

        List<int []> resultList = new ArrayList<>();



        for(int i = 0; i < updatedIntervals.length; i++) {
            int[] currentInterval = updatedIntervals[i];
            while(i < updatedIntervals.length && doesIntervalsOverlap(currentInterval, updatedIntervals[i])) {
                currentInterval = mergeInterval(currentInterval, updatedIntervals[i]);
                i++;
            }
            i--;
            resultList.add(currentInterval);
        }

        return resultList.toArray(new int[resultList.size()][2]);

    }
}
