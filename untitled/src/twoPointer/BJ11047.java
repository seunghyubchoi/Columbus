package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류 N 개
        int K = Integer.parseInt(st.nextToken()); // K 원
        int[] arr = new int[N];
        int count = 0;


        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= K) {
                count += (K / arr[i]);
                K = K % arr[i];
            }
        }
        System.out.println(count);
    }
}
