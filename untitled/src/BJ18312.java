import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if(i < 10) {
                        sb.append(0);
                    }
                    sb.append(i);
                    if (j < 10) {
                        sb.append(0);
                    }
                    sb.append(j);
                    if (k < 10) {
                        sb.append(0);
                    }
                    sb.append(k);
                    String result = sb.toString();
                    if (result.contains(String.valueOf(K))) {
                        count++;
                    }
                    sb.setLength(0);
                }
            }
        }
        System.out.println(count);
    }
}
