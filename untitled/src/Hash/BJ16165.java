package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BJ16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 걸그룹의 수
        int M = Integer.parseInt(st.nextToken()); // 맞혀야할 문제의 수
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String teamName = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < memberCount; j++) {
                list.add(br.readLine());
            }
            map.put(teamName, list);
        }

        for (int i = 0; i < M; i++) {
            String memberOrTeam = br.readLine();
            int oneOrZero = Integer.parseInt(br.readLine());

            if (oneOrZero == 1) {
                for (String team : map.keySet()) {
                    if (map.get(team).contains(memberOrTeam)) {
                        System.out.println(team);
                    }
                }
            } else {
                ArrayList<String> memberList = map.get(memberOrTeam);
                Collections.sort(memberList);
                for (String s : memberList) {
                    System.out.println(s);
                }

            }
        }


    }
}
