package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '(') {
                    stack.push(arr[j]);
                } else if (arr[j] == ')') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty() && flag == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

