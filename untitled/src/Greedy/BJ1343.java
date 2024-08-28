package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer = str.replaceAll("XXXX", "AAAA");
        answer = answer.replaceAll("xx", "BB");
        if (answer.contains("x")) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
}
