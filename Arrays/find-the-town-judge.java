// LC 997: Find the town judge

public class LC997 {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n];

        for(int[] t: trust) {
            trustCount[t[1] - 1] += 1;
            trustCount[t[0] - 1] -= 1;
        }

        int index = -1;

        for(int i = 0; i<trustCount.length; i++) {
            if(trustCount[i] == n-1) {
                index = i;
                return index + 1;
            }
        }

        return index;
    }
}
