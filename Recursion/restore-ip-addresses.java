// LC 93: Restore IP Addresses

import scala.Int;

import java.util.ArrayList;
import java.util.List;

public class LC93 {

    public static void main(String[] args) {
        String s = "101023";
        System.out.println(
                new LC93().restoreIpAddresses(s)
        );
    }

    private void backtrackIPAddress(List<String> result, String input, String resultingSequence, int startIndex, int currentDots) {
        if(startIndex >= input.length()) {
            return;
        }
        if(currentDots == 3) {
            //System.out.println(input.substring(startIndex, input.length()));
            if(input.substring(startIndex, input.length()).equals("0") ||
                    (!input.substring(startIndex, startIndex + 1).equals("0")
                            && input.substring(startIndex, input.length()).length() <= 3
                            && Integer.valueOf( input.substring(startIndex, input.length()) ) <= 255
                    )
            ) {
                result.add(new String(resultingSequence + input.substring(startIndex, input.length())));
                return;
            }
            return;
        }
        if(startIndex + 1 <= input.length() && input.substring(startIndex, startIndex + 1).equals("0")) {
            backtrackIPAddress(result, input, resultingSequence + "0.", startIndex + 1, currentDots + 1);
        } else {
            if(startIndex + 1 <= input.length()) {
                backtrackIPAddress(result, input, resultingSequence + input.substring(startIndex, startIndex + 1) +".", startIndex + 1, currentDots + 1);
            }
            if(startIndex + 2 <= input.length()) {
                backtrackIPAddress(result, input, resultingSequence + input.substring(startIndex, startIndex + 2) +".", startIndex + 2, currentDots + 1);
            }
            if(startIndex + 3 <= input.length() && Integer.valueOf( input.substring(startIndex, startIndex + 3) ) <= 255) {
                backtrackIPAddress(result, input, resultingSequence + input.substring(startIndex, startIndex + 3) +".", startIndex + 3, currentDots + 1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> resultList = new ArrayList<>();

        if(s.length() > 12) {
            return resultList;
        }

        int dots = 0;

        this.backtrackIPAddress(resultList, s, "", 0, dots);
        return resultList;
    }
}
