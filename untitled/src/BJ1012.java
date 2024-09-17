import java.io.*;
import java.util.StringTokenizer;

public class BJ1012 {
    static final int MAX = 50 + 10;
    static boolean graph[][];
    static boolean[][] visited;
    static int T, M, N, K;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                if (graph[newX][newY] && !visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            graph = new boolean[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = true;
            }
            // dfs 수행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            bw.write(String.valueOf(answer));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
