// LC 953: Verify an Alien Dictionary

import java.util.HashMap;
import java.util.Map;

public class LC953 {

    public static void main(String[] args) {
        String[] words = new String[] {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(
                new LC953().isAlienSorted(words, order)
        );
    }

    private boolean areWordsInOrder(String firstWord, String secondWord, Map<Character, Integer> orderMap) {
        int i = 0;
        while(i < Math.min(firstWord.length(), secondWord.length())) {
            if(orderMap.get(firstWord.charAt(i)) > orderMap.get(secondWord.charAt(i)) ) {
                return false;
            } else if (orderMap.get(firstWord.charAt(i)) < orderMap.get(secondWord.charAt(i))) {
                return true;
            } else {
                i++;
            }
        }

        if(firstWord.length() > secondWord.length()) {
            return false;
        }

        return true;
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();

        for(int i = 0; i< order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length - 1; i++) {
            if(!this.areWordsInOrder(words[i], words[i + 1], orderMap)) return false;
        }

        return true;
    }
}
