package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16165 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            while (t-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int n = Integer.parseInt(st.nextToken());
                int degree = Integer.parseInt(st.nextToken());
                if (degree < 0) degree += 360;
                degree /= 45;

                int[][] arr = new int[n][n];
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                while (degree-- > 0) { // degree 횟수만큼 배열을 시계방향으로 45도 회전
                    rotate(arr);
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sb.append(arr[i][j] + " ");
                    }
                    sb.append("\n");
                }
            }
            System.out.println(sb);
        }

        static void rotate(int[][] arr) {
            int n = arr.length;
            int[] copy = new int[n];

            // 가운데 열 숫자들을 미리 copy 배열에 저장
            for (int i = 0; i < n; i++) {
                copy[i] = arr[i][n/2];
            }

            // 4개의 줄 이동시키기
            for (int i = 0; i < n; i++) {
                arr[i][n/2] = arr[i][i];
                arr[i][i] = arr[n/2][i];
                arr[n/2][i] = arr[n-i-1][i];
                arr[n-i-1][i] = copy[n-1-i]; // 순서 반대로 해서 집어넣기
            }
        }
    }