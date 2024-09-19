package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2606_3 {
    static int N, M;
    static boolean[][] map;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        M = Integer.parseInt(br.readLine()); // 연결되어 있는 컴퓨터 쌍의 수
        map = new boolean[N + 1][N + 1]; // N개 포함하기에 N + 1
        visited = new boolean[N + 1]; // 이미 방문했는지 여부 표기를 위해
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
            map[y][x] = true; // 반대의 경우도 true, 이미 방문한 곳을 무시하기 위함
        }
        dfs(1); // 1번 컴퓨터부터 시작
        System.out.println(answer - 1); // 시작 컴퓨터를 제외

    }

    private static void dfs(int index) {
        visited[index] = true;
        answer++;
        for (int i = 1; i <= N; i++) { // 1번부터 N번까지
            if (!visited[i] && map[index][i] ) {
                dfs(i);
            }
        }
    }
}
