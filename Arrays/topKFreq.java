import java.util.*;

public class TopKFreqElems {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] inst1 = new TopKFreqElems().topKFrequent(nums, 2);
        for(int a: inst1) {
            System.out.println(a);
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsCount = new HashMap<>();
        List<Integer>[] countArray = new ArrayList[nums.length + 1];
        List<Integer> result = new ArrayList<>();
        int count = 0;

        // adding values to hashmap
        for(int n: nums) {
            numsCount.put(n, numsCount.getOrDefault(n, 0) + 1);
        }

        // adding values to bucket array where index is count and value is an array list of numbers with same count
        for(Integer key: numsCount.keySet()) {
            if(!(countArray[numsCount.get(key)] instanceof List<Integer>)) {
                countArray[numsCount.get(key)] = new ArrayList<>();
            }
            countArray[numsCount.get(key)].add(key);
        }

        int i = countArray.length - 1;
        while(count < k && i > 0) {
            if(countArray[i] != null) {
                if(k - count > countArray[i].size()) {
                    result.addAll(countArray[i]);
                    count += countArray[i].size();
                } else {
                    for(Integer num: countArray[i]) {
                        result.add(num);
                        count += 1;
                    }
                }
            }
            --i;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
