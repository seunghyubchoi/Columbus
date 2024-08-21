package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sieve2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // N 까지의 수
        int K = Integer.parseInt(st.nextToken()); // K 번째 지우는 수

        int[] arr = new int[N + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int count = 0;
        boolean flag = true;
        int P = 0;

        for (int i = 2; i < arr.length; i++) {
            if(arr[i] == 0) continue;
            if (flag) {
                for (int j = i; j < arr.length; j += i) {
                    if (count == K) {
                        flag = false;
                        break;
                    }
                    P = arr[j];
                    if (arr[j] != 0) {
                        arr[j] = 0;
                        count++;
                    }
                }
            }
        }
        System.out.println(P);
    }
}
