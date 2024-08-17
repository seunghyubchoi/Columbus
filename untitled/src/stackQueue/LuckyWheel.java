package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LuckyWheel {
    public static void main(String[] args) throws IOException {
        // HONITAVR
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 바퀴의 칸 수
        int K = Integer.parseInt(st.nextToken()); // 상덕이가 바퀴를 돌리는 횟수
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken()); // 화살표가 가리키는 글자가 바뀐 횟수
            char W = st.nextToken().charAt(0); // 회전을 멈췄을 때 가리키던 글자
        }

    }
}
