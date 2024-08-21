package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class MathHomework {

    static ArrayList<BigInteger> list = new ArrayList<>();
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 줄의 개수

        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch >= 'A' && ch <= 'z') {
                    checkStringBuilderLength(sb.length(), sb.toString());
                } else  {
                    sb.append(ch);
                }
            }
            checkStringBuilderLength(sb.length(), sb.toString());
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void checkStringBuilderLength(int length, String str) {
        if (length != 0) {
            list.add(new BigInteger(str));
            sb.setLength(0);
        }
    }
}
