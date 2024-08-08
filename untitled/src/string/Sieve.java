package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sieve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[end + 1]; // default : false = 소수
        StringBuilder sb = new StringBuilder();

        // 소수가 아닌 0과 1
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i * i <= end; i++) {
            // i를 제곱해서 end의 값을 넘지 않는 수일때 조건
            // 넘
        }



    }
}
