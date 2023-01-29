// LC 76. Minimum Window Substring

import java.util.HashMap;
import java.util.Map;

public class LC76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(
                new LC76().minWindow(s, t)
        );
    }

    class Window {
        int startIndex;
        int endIndex;

        public Window(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;

        Window resultIndices = null;

        if(t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tDictionary = new HashMap<>();
        Map<Character, Integer> sDictionary = new HashMap<>();

        for(int i = 0; i<t.length(); i++) {
            tDictionary.put(new Character(t.charAt(i)), tDictionary.getOrDefault(t.charAt(i), 0) + 1);
        }

        int need = tDictionary.size();
        // System.out.println(charDictionary);
        int have = 0;

        while(left <= right && right < s.length()) {

            if(tDictionary.containsKey(s.charAt(right)) &&
                sDictionary.getOrDefault(s.charAt(right), 0) + 1 == tDictionary.get(s.charAt(right)) ) {
                have++;
            }

            sDictionary.put(new Character(s.charAt(right)), sDictionary.getOrDefault(s.charAt(right), 0) + 1);

            if(have == need) {
                if(resultIndices == null) {
                    resultIndices = new Window(left, right);
                }

                while(have == need) {
                    resultIndices = (resultIndices.endIndex - resultIndices.startIndex) > (right - left) ? new Window(left, right) : resultIndices;
                    // remove left
                    sDictionary.put(s.charAt(left), sDictionary.get(s.charAt(left)) - 1);

                    if(tDictionary.containsKey(s.charAt(left)) && sDictionary.get(s.charAt(left)) == tDictionary.get(s.charAt(left)) - 1) {
                        have--;
                    }
                    left++;

                }
            }

            right++;
        }


        return resultIndices != null ? s.substring(resultIndices.startIndex, resultIndices.endIndex + 1): "";
    }
}
