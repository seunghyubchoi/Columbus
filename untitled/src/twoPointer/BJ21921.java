package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 시작한 지 벌써 N일 지남
        int X = Integer.parseInt(st.nextToken()); // X일 동안 가장 많이 들어온 방문자 수와 그 기간들

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 각 일 마다 방문자 수
        }

        int sum = 0;
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < X; i++) {
            sum += arr[i]; // 맨 처음 X일 동안의 방문자 수
        }
        list.add(sum); // 첫 번째 X일 동안의 방문자 수 합
        answer = sum;
        for (int i = X; i < arr.length; i++) {
            sum += (arr[i] - arr[i - X]); // X번째 인덱스의 수 부터 시작, X번째 이전의 수를 빼주면서 반복
            list.add(sum);
            answer = Math.max(answer, sum);
        }
        if(answer == 0) {
            System.out.println("SAD");
        } else {
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (answer == list.get(i)) {
                    count++;
                }
            }
            System.out.println(answer);
            System.out.println(count);
        }


    }
}
