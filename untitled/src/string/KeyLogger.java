package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class KeyLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.setLength(0);
            Stack<Character> stack = new Stack<>();
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                switch(ch) {
                    case '<' :
                        if(stack.isEmpty()) continue;
                        char popChar = stack.pop();
                        sb.append(popChar);
                        break;
                    case '>' :
                        if(sb.length() == 0) continue;
                        char sbChar = sb.charAt(sb.length() - 1);
                        stack.push(sbChar);
                        sb = sb.deleteCharAt(sb.length() - 1);
                        break;
                    case '-' :
                        if(stack.isEmpty()) continue;
                        stack.pop();
                        break;
                    default:
                        stack.push(ch);
                        break;
                }
            }
            StringBuilder result = new StringBuilder();

            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            result = result.reverse();
            result.append(sb.reverse());
            System.out.println(result.toString());
        }
    }
}
