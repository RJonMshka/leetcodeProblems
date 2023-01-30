// LC 1137. N-th Tribonacci Number

class Solution {
    public int tribonacci(int n) {
        int i = 0;
        int j = 1;
        int k = 1;
        int sum = 0;

        if(n < 3) {
            if(n == 0) return i;
            return j;
        }

        for(int l = 3; l <= n; l++) {
            sum = i + j + k;
            i = j;
            j = k;
            k = sum;
        }

        return sum;
    }
}