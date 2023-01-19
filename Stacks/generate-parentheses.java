// Leetcode 22: Geenerate Parentheses

import java.util.List;
import java.util.ArrayList;

public class LC22 {

    public static void main(String[] args) {
        new LC22().generateParenthesis(3);
    }

    private void addGeneratedStringToResult(List<String> resultList, String parenthesesString, int currentOpen, int currentClosed, int limit) {
        if(currentOpen == limit && currentClosed == limit) {
            resultList.add(parenthesesString);
            return;
        }
        if(currentOpen < limit) {
            addGeneratedStringToResult(resultList, parenthesesString + "(", currentOpen + 1, currentClosed, limit);
        }
        if(currentClosed < currentOpen && currentClosed < limit) {
            addGeneratedStringToResult(resultList, parenthesesString + ")", currentOpen, currentClosed + 1, limit);
        }

    }

    public List<String> generateParenthesis(int n) {
        int open = 1;
        int close = 0;
        String initParantheses = "(";

        List<String> result = new ArrayList<>();

        this.addGeneratedStringToResult(result, initParantheses, open, close, n);

        System.out.println(result.toString());

        return result;
    }


}
