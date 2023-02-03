// LC: 6. Zigzag Conversion

public class LC6 {
    public static void main(String[] args) {
        String inputString = "PAYPALISHIRING";
        int rows = 4;

        System.out.println(
                new LC6().convert(inputString, rows)
        );
    }
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;

        String output = "";

        for(int i = 0; i < numRows; i++) {
            int j = i;
            boolean toggle = true;
            while (j < s.length()) {
                output += s.charAt(j);
                if(i == 0 || i == numRows - 1) {
                    j += (2 * numRows - 2);
                } else {
                    if(toggle) {
                        j += ((2 * numRows) - 2 - (2 * i));
                        toggle = false;
                    } else {
                        j += 2 * i;
                        toggle = true;
                    }

                }
            }
        }

        return output;
    }
}
