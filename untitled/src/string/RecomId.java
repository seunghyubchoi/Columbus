package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class RecomId {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String new_id = br.readLine();
        System.out.println(solution(new_id));
    }

    static public String solution(String new_id) {
        int originLength = new_id.length();

        // 1단계 소문자로 치환
        String answer = new_id.toLowerCase();

        // 2단계 알파벳, 숫자, 빼기, 밑줄, 마침표 제외 모든 문자 제거
        for (int i = 0; i < answer.length(); i++) {
            char ch = answer.charAt(i);
            if ((ch == '-' || ch == '_' || ch == '.')) {
                sb.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else if (ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            }
        }
        answer = saveAnswer(sb);
        // 3단계  '..', '...'이면 '.'으로 치환
        if (answer.length() > 1) {
            for (int i = 0; i < answer.length() - 1; i++) {
                char ch = answer.charAt(i);
                if (ch == '.' && answer.charAt(i + 1) == '.') {
                    continue;
                } else {
                    sb.append(ch);
                    if(i == answer.length() - 2) {
                        sb.append(answer.charAt(i + 1));
                    }
                }
            }
            answer = saveAnswer(sb);
        }


        // 4단계 아이디의 처음에 위치한 '.' 제거
        if (answer.charAt(0) == '.') {
            for (int i = 1; i < answer.length(); i++) {
                sb.append(answer.charAt(i));
            }
            answer = saveAnswer(sb);
        }

        if(answer.equals("")) {

                sb.append('a');

            answer = saveAnswer(sb);
        }

        if (answer.length() >= 16) {
            for (int i = 0; i < 15; i++) {
                sb.append(answer.charAt(i));
            }

            if(sb.charAt(14) == '.') {
                sb.delete(14,15);
            }
            answer = saveAnswer(sb);
        }

        if (answer.length() <= 2) {
            char letter = answer.charAt(answer.length() - 1);
            sb.append(answer);
            while (sb.length() != 3) {
                sb.append(letter);
            }
            answer = saveAnswer(sb);
        }


        return answer;
    }

    public static String saveAnswer(StringBuilder sb) {
        String answer = sb.toString();
        sb.setLength(0);
        return answer;
    }
}
