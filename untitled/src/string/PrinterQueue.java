package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < total; i++) {
            q.clear();
            st = new StringTokenizer(br.readLine(), " ");
            int docCnt = Integer.parseInt(st.nextToken()); // 총 문서 갯수
            int docIndex = Integer.parseInt(st.nextToken()); // 찾으려는 문서의 위치 인덱스

            st = new StringTokenizer(br.readLine(), " "); // 각 문서의 중요도

            int[] arr = new int[docCnt]; // 입력한 숫자들을 담을 배열

            for(int j = 0; j < docCnt; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
                q.offer(j);
            }

            int count = 0;
            while (!q.isEmpty()) {
                boolean chk = false;
                int pollNum = q.poll();
                for (int j : arr) {
                    if (arr[pollNum] < j) { // 현재 값과 나머지 내부에 있는 값을 비교
                        q.offer(pollNum); // 내부에 자기 자신보다 큰 값이 있는 경우 뒤로
                        chk = true;
                        break;
                    }
                }

                if (!chk) { // 현재 값이 가장 큰 경우
                    count++; // 인쇄 횟수 변수 증가
                    arr[pollNum] = 0; // 더 이상 값을 체크하지 않기 위해 0으로
                    if (pollNum == docIndex) { // 큐에 있던 중요도와 찾으려는 중요도 값이 같으면
                        System.out.println(count); // 출력 후 종료
                        break;
                    }
                }
            }
        }
    }
}
