package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class primeNumCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (testCase-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(d < 0) d += 360;
            d /= 45;

            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }



            while (d-- > 0) {
                rotate1(arr);
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append(arr[j][k] + " ");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }

    static void rotate1(int[][] arr) {
        int n = arr.length;
        int[] copy = new int[n];


        for (int i = 0; i < n; i++) {
            copy[i] = arr[i][n/2];
        }


        for (int j = 0; j < n; j++) {
            arr[j][n/2] = arr[j][j];
            arr[j][j] = arr[n/2][j];
            arr[n/2][j] = arr[n-j-1][j];
            arr[n-j-1][j] = copy[n-1-j];
        }
    }
}