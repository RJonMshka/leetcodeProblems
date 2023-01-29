import java.util.List;
import java.util.TreeSet;

public class LC352 {
    class SummaryRanges {
        TreeSet<Integer> storedValues;

        public SummaryRanges() {
            this.storedValues = new TreeSet<>();
        }

        public void addNum(int value) {
            this.storedValues.add(value);
        }

        public int[][] getIntervals() {
            if(this.storedValues.isEmpty()) {
                return new int[0][2];
            }

            List<int[]> finalList = new List<>();

            int left = -1;
            int right = -1;

            for(Integer value: this.storedValues) {
                if(left < 0) {
                    left = value.intValue();
                    right = value.intValue();
                } else if (value == right + 1) {
                    right = value;
                } else {
                    finalList.add(new int[] {left, right});
                    left = value;
                    right = value;
                }
            }
            finalList.add(new int[] {left, right});

            return finalList.toArray(new int[0][]);

        }
    }
}
