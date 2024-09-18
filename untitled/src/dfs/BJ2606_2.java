package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2606_2 {

    static int N,K,x,y;
    static boolean[][] graph;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        StringTokenizer st;
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

    private static void dfs(int i) {
        visited[i] = true;
        answer++;
        for (int j = 1; j <= N; j++) {
            if (visited[j] == false && graph[i][j]) {
                dfs(j);
            }
        }
    }
}
