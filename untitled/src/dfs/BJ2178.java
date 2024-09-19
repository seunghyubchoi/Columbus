package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178 {
    static int N;
    static int M;
    static int[][] map;
    static int count;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static boolean[][] visited;

    public static void dfs(int tmp) {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(ch[j]);
            }
        }

        visited[0][0] = true;
        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<spot> queue = new LinkedList<>();
        queue.add(new spot(x, y)); // 0,0 부터 시작

        while (!queue.isEmpty()) {
            spot s = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = s.x + dirX[i];
                int nextY = s.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue; // 이미 방문했거나 1이 아닌 곳은 넘어감
                }

                queue.add(new spot(nextX, nextY)); // 모든 if 통과 시 좌표 추가
                map[nextX][nextY] = map[s.x][s.y] + 1; // 해당 좌표에 기존 좌표의 값에서 1을 더 함
                visited[nextX][nextY] = true; // 이동할 좌표는 방문한 곳이 되니 true
            }
        }

    }

    static class spot{
        int x;
        int y;

        spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
