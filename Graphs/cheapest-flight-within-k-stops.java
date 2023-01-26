// LC 787. Cheapest Flights Within K Stops

import java.util.Arrays;

public class LC787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        // k + 1 time as we have to find route with atmost k + 1 edges
        // Bellman Ford Algo
        for(int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(distance, n);

            for(int[] flight: flights) {
                if(distance[flight[0]] != Integer.MAX_VALUE) {
                    temp[flight[1]] = Math.min(temp[flight[1]], distance[flight[0]] + flight[2]);
                }
            }
            // copy the array in each iteration of total k+1
            distance = temp;
        }

        return distance[dst] != Integer.MAX_VALUE ? distance[dst] : -1;
    }
}
