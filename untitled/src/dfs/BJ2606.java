package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2606 {
    static boolean[][] graph;
    static boolean[] visited;
    static int x,y;
    static int N,K;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        StringTokenizer st;

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(1);
        bw.write(String.valueOf(answer - 1));

        br.close();
        bw.close();
    }

    private static void dfs(int index) {
        visited[index] = true;
        answer++;
        for (int i = 1; i < N; i++) {
            if (visited[i] == false && graph[index][i]) {
                dfs(i);
            }
        }
    }
}
