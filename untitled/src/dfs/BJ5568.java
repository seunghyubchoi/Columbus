package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BJ5568 {
    static int n,k;
    static String[] arr;
    static boolean[] visited;
    static ArrayList<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 총 카드 수
        k = Integer.parseInt(br.readLine()); // 뽑을 카드 수
        visited = new boolean[n];
        list = new ArrayList<>();
        arr = new String[n]; // 카드 담은 배열, 1, 2, 12, 1

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        dfs(0, "");
        System.out.println(list.size());
    }

    public static void dfs(int count, String word) {
        if(count == k) {
            if (!list.contains(word)) {
                list.add(word);
            }

        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(count + 1, word + arr[i]);
                    visited[i] = false;
                }
            }
        }
    }

}
