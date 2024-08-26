package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ9375_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < Testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String kind = st.nextToken();

                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            int count = 1;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                count *= (entry.getValue() + 1); // null 때문에 1 추가
            }
            sb.append(count - 1).append('\n'); // 모두 null인 경우 1 빼기
        }
        System.out.println(sb);
    }
}
