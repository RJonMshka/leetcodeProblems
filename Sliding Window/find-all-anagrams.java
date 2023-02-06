// LC 438: Find all anagrams in a string

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(
                new LC438().findAnagrams(s, p)
        );
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> sCurrentMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        if(p.length() > s.length()) return result;

        int have = 0;

        for(int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sCurrentMap.put(s.charAt(i), sCurrentMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int need = pMap.size();

        for(char c: pMap.keySet()) {
            if(sCurrentMap.containsKey(c) && sCurrentMap.get(c).intValue() == pMap.get(c).intValue()) {
                have += 1;
            }
        }

        if(have == need) {
            result.add(new Integer(0));
        }

        for(int i = 1; i < s.length() - p.length() + 1; i++) {
            int left = i;
            int prevLeft = i - 1;
            int right = i + p.length() - 1;

            if( pMap.containsKey(s.charAt(prevLeft)) && sCurrentMap.get(s.charAt(prevLeft)).intValue() == pMap.get(s.charAt(prevLeft)).intValue()) {
                have -= 1;
            } else if (pMap.containsKey(s.charAt(prevLeft)) && sCurrentMap.get(s.charAt(prevLeft)).intValue() - 1 == pMap.get(s.charAt(prevLeft)).intValue()) {
                have += 1;
            }

            // reduce count of previous left one
            sCurrentMap.put(s.charAt(prevLeft), sCurrentMap.get(s.charAt(prevLeft)) - 1);

            // now add the new right
            if( pMap.containsKey(s.charAt(right)) && sCurrentMap.getOrDefault(s.charAt(right), 0).intValue() + 1 == pMap.get(s.charAt(right)).intValue()) {
                have += 1;
            } else if (pMap.containsKey(s.charAt(right)) && sCurrentMap.getOrDefault(s.charAt(right), 0).intValue() == pMap.get(s.charAt(right)).intValue()) {
                have -= 1;
            }

            sCurrentMap.put(s.charAt(right), sCurrentMap.getOrDefault(s.charAt(right), 0) + 1);

            if(have == need) {
                result.add(new Integer(i));
            }
        }

        return result;

    }
}
