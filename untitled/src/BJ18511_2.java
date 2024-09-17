import java.io.*;
import java.util.*;

public class BJ18511_2 {
    static int[] arr;
    static int N,K,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        arr = new int[K];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        br.close();
        bw.write(String.valueOf(answer));
        bw.close();
    }

    private static void dfs(int value) {
        if(value > N) return;
        if(answer < value) answer = value;

        for (int i = 0; i < K; i++) {
            dfs(value * 10 + arr[i]);
        }
    }
}
