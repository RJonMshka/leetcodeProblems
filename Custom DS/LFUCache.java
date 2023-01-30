// LC 460. LFU Cache

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LC460 {

    class LFUCache {
        Map<Integer, Pair<Integer, Integer>> cache;
        Map<Integer, Set<Integer>> frequencies;
        int capacity;

        int minimumFrequency = 0;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            frequencies = new HashMap<>();
        }

        private void addKey(int key, int newFrequency, int value) {
            cache.put(key, new Pair<>(newFrequency, value));
            frequencies.putIfAbsent(newFrequency, new LinkedHashSet<>());
            frequencies.get(newFrequency).add(key);
        }

        public int get(int key) {
            if(!cache.containsKey(key)) return -1;

            Pair<Integer, Integer> frequencyValue = this.cache.get(key);
            int currentFrequency = frequencyValue.getKey().intValue();
            int value = frequencyValue.getValue().intValue();

            Set<Integer> keys = frequencies.get(currentFrequency);
            keys.remove(key);

            if(minimumFrequency == currentFrequency && keys.isEmpty()) {
                // no such minimum frequency left, so new frequency is the minimum frequency
                minimumFrequency++;
            }

            this.addKey(key, currentFrequency + 1, value);

            return value;
        }

        public void put(int key, int value) {
            if(capacity <= 0) {
                return;
            }

            Pair<Integer, Integer> frequencyValue = this.cache.get(key);

            // if it exists
            // need to check it first as if key exists, the capacity would not change
            if(frequencyValue != null) {
                cache.put(key, new Pair<>(frequencyValue.getKey(), value));
                this.get(key);
                return;
            }

            if(cache.size() == this.capacity) {
                // remove the least frequently used first
                Set<Integer> minimumFrequencyKeys = frequencies.get(minimumFrequency);
                int keyToRemove = minimumFrequencyKeys.iterator().next();
                minimumFrequencyKeys.remove(keyToRemove);
                cache.remove(keyToRemove);
            }

            // else
            minimumFrequency = 1;
            this.addKey(key, 1, value);


        }
    }
}
