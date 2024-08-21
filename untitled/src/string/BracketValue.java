package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BracketValue {
    public static void main(String[] args) throws IOException {
        // 올바른 괄호인지 구하기
        // 올바른 괄호라면 계산하기
        // 스택에 있는 거랑 pop 한거랑 짝이 안 맞으면 되는 것 아닌가?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int calNum = 1;
        boolean flag = true;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[') {
                if(ch == '(') {
                    calNum *= 2;
                } else {
                    calNum *= 3;
                }
                stack.push(ch);
            } else { // ')' or ']'
                if (stack.isEmpty()) { // 남은 문자와 수가 안 맞을 때 false
                    flag = false;
                    break;
                }
                char popChar = stack.pop();
                // 꺼냈는데 짝이 안 맞을 때 false
                if ((ch == ')' && popChar == '[') || (ch == ']' && popChar == '(')) {
                    flag = false;
                    break;
                }

                // 당장 ch 바로 앞에 있는 문자가 여는 괄호 일 때만 계산해주어야 함
                char innerChar = str.charAt(i - 1);
                if ((ch == ')' && innerChar == '(') || (ch == ']' && innerChar == '[')) {
                    result += calNum;
                }

                // innerChar 대신 popChar 를 사용하게 되면
                // 그간 누적해온 calNum이 연속적으로 계산됨
                //

                if(ch == ')') {
                    calNum /= 2;
                } else {
                    calNum /= 3;
                }

                // popChar == (, ch == )
                // () -> 2
                // 만약에 스택에 (( 있고 else 타서 )) 면?
                // (( ) -> () 이니까 일단 calNum 2로 바꿔주고
                // 또 있으니까 바꿨던 calNum 다시 2또 곱해주고
                // [()] 도 마찬가지
                // [() -> () 이니까 일단 calNum 2로 바꿔주고
                // [] 또 있으니까 calNum 에서 3곱해줘서 ([ 나오면 그 때 calNum 값을 계산
            }
        }
        if(!flag) {
            System.out.println(0);
        } else if (flag && !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
