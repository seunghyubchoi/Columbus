package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SteeleStick {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bracket = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < bracket.length(); i++) {
            if (bracket.charAt(i) == '(') {
                stack.push(bracket.charAt(i));
            } else if (bracket.charAt(i) == ')') { // ')' 인 경우에
                if(bracket.charAt(i - 1) == '(') { // 이전 문자가 '('인 경우
                    stack.pop(); // 스택에서 하나를 없애주고
                    count = count + stack.size(); // 현재 스택의 사이즈 즉, 줄 만큼 더 해준다.
                } else { // 이전 문자가 ')' 인 경우, 레이저 쏘는 게 아닌 쇠막대기의 종료
                    stack.pop(); // 스택에서 하나를 없애주고
                    count += 1; // 남은 조각 하나를 추가해준다
                }
            }
        }
        System.out.println(count);
    }
}
