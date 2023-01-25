// 2359. Find Closest Node to Given Two Nodes

import java.util.ArrayList;
import java.util.Arrays;

public class LC2359 {
    public static void main(String[] args) {
        int[] edges = {2,2,3,-1};
        int node1 = 0;
        int node2 = 1;
        System.out.println(
                new LC2359().closestMeetingNode(edges, node1, node2)
        );
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        for(int i = 0; i < n; i++) {
            dist1[i] = -1;
            dist2[i] = -1;
        }

        dist1[node1] = 0;
        dist2[node2] = 0;

        int nextNode1 = node1;
        int nextNode2 = node2;

        while(nextNode1 != -1) {
            int prevDistance = dist1[nextNode1];
            nextNode1 = edges[nextNode1];

            if(nextNode1 != -1 && dist1[nextNode1] == -1) {
                dist1[nextNode1] = prevDistance + 1;
            } else {
                // cycle detected
                break;
            }
        }

        while(nextNode2 != -1) {
            int prevDistance = dist2[nextNode2];
            nextNode2 = edges[nextNode2];

            if(nextNode2 != -1 && dist2[nextNode2] == -1) {
                dist2[nextNode2] = prevDistance + 1;
            } else {
                // cycle detected
                break;
            }
        }

        int result = Integer.MAX_VALUE;
        int resultIndex = -1;

        for(int i = 0; i < n; i++) {
            if(dist1[i] != -1 && dist2[i] != -1) {
                if( result > Math.max(dist1[i], dist2[i]) ) {
                    result = Math.max(dist1[i], dist2[i]);
                    resultIndex = i;
                }
            }
        }

        return resultIndex;
    }
}
