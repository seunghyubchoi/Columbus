package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Testcase = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < Testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String kind = st.nextToken();

                if (map.containsKey(kind)) {
                    map.put(kind, map.get(kind) + 1);
                } else {
                    map.put(kind, 1);
                }
            }

            int result = 1;

            for (int count : map.values()) {
                result *= (count + 1); // null을 포함해줘야 하기에 1
            }

            System.out.println(result - 1); // 전부 다 null 인 경우를 제외하기에 -1
        }
    }
}
