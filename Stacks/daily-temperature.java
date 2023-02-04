// LC 739: Daily Temperatures


import java.util.Stack;

public class LC739 {

    public static void main(String[] args) {
        int[] temps = new int[] {73,74,75,71,69,72,76,73};
        int[] output = new LC739().dailyTemperatures(temps);

        for(int o: output) {
            System.out.print(o + " ");
        }

    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> tempStack = new Stack<>();
        int[] output = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            if(tempStack.isEmpty()) {
                tempStack.add(new Integer(i));

            } else {
                while (!tempStack.isEmpty() && temperatures[tempStack.peek()] < temperatures[i]) {
                    output[tempStack.peek()] = i - tempStack.peek();
                    tempStack.pop();
                }
                tempStack.add(new Integer(i));
            }
        }
        for(Integer se: tempStack) {
            output[se] = 0;
        }

        return output;
    }
}

