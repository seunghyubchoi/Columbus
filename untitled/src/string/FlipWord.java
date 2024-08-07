package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlipWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean flag = true; // 대칭 반전 판가름할 flag 변수
        StringBuilder sb = new StringBuilder(); // 임시 문자열을 담을 StringBuilder
        StringBuilder answer = new StringBuilder(); // 최종 문자열을 담을 StringBuilder

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                flag = false;
                answer.append(sb.reverse()).append(str.charAt(i)); // 기존에 담긴 문자열을 반전 시켜 담고 괄호까지 추가
                sb.setLength(0); // StringBuilder 초기화
            } else if (str.charAt(i) == '>') {
                flag = true;
                answer.append(sb).append(str.charAt(i)); // 괄호 안에 담길 문자열을 반전 시키지 않고 담고 괄호까지 추가
                sb.setLength(0); // StringBuilder 초기화
            } else if (str.charAt(i) == ' ') { // 공백인 경우 기존 문자열을 반전 시킬지 말지 결정해야 함
                if (flag) {
                    answer.append(sb.reverse()).append(str.charAt(i)); // 괄호 밖인 경우 공백 기준으로 반전 시킨 뒤 추가 후 공백까지 추가
                    sb.setLength(0); // StringBuilder 초기화
                } else {
                    answer.append(sb).append(str.charAt(i)); // 괄호 내부 인 경우 그냥 담고 공백까지 추가해서 담음
                    sb.setLength(0); // StringBuilder 초기화
                }
            } else {
                sb.append(str.charAt(i)); // 괄호나 공백이 아닌 경우 임시 문자열 담기
            }
        }
        System.out.println(answer.append(sb.reverse())); // 임시 Builder에 담긴 괄호 및 공백이 아닌 임시 문자열 전부 반전 후 추가
        // sb에 남은 문자열이 존재하기 때문
    }
}
