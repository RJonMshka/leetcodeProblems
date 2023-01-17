// LC: 150. Evaluate Reverse Polish Notation

import java.util.Stack;

public class LC150 {

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(
                new LC150().evalRPN(tokens)
        );
    }

    private Integer operate(Integer first, Integer second, String operator) {
        switch (operator) {
            case "+": return first + second;
            case "-": return first - second;
            case "*": return first * second;
            case "/": return first / second;
            default: break;
        }
        return null;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> intStack = new Stack<>();
        String operators = "+-/*";
        for(String t: tokens) {
            if(operators.indexOf(t) == -1) {
                intStack.push(Integer.valueOf(t));
            } else {
                int secondOperand = intStack.pop();
                int firstOperand = intStack.pop();
                intStack.push( this.operate(firstOperand, secondOperand, t) );
            }
        }

        return intStack.peek().intValue();
    }


}
