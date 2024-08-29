package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시의 개수

        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 도로의 길이
        long[] distance = new long[N - 1];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        long[] cost = new long[N];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = cost[0];
        for (int i = 0; i < cost.length - 1; i++) {
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            sum += (minCost * distance[i]);
        }
        System.out.println(sum);
    }
}
