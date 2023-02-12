// LC 2306: Naming a Company

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LC2306 {
    public static void main(String[] args) {
        String[] ideas = new String[] {
                "coffee","donuts","time","toffee"
        };

        System.out.println(
                new LC2306().distinctNames(ideas)
        );
    }

    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> suffixMap = new HashMap<>();
        long result = 0;

        for(String s: ideas) {
            if (!suffixMap.containsKey(s.charAt(0))) {
                Set<String> suffixSet = new HashSet<String>();
                suffixSet.add(s.substring(1));
                suffixMap.put(s.charAt(0),  suffixSet);
            } else {
                Set<String> suffixSet = suffixMap.get(s.charAt(0));
                suffixSet.add(s.substring(1));
            }
        }

        Character[] keySet = suffixMap.keySet().toArray(new Character[suffixMap.keySet().size()]);

        for(int i = 0; i < keySet.length - 1; i++) {
            for(int j = i + 1;  j < keySet.length; j++) {
                Set<String> firstSet = suffixMap.get(keySet[i]);
                Set<String> secondSet = suffixMap.get(keySet[j]);
                long intersectionCount = firstSet.stream().filter(secondSet::contains).count();
                result += 2 * (firstSet.size() - intersectionCount) * (secondSet.size() - intersectionCount);
            }
        }

        return result;
    }
}
