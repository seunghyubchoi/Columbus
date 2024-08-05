package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AddNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine()); // 입력 받을 숫자의 개수를 입력 받습니다.
        String num = br.readLine(); // 문자열로 된 숫자들을 입력 받습니다.
        char[] arr = new char[count]; // 입력 받을 숫자 만큼의 배열을 생성해주고,
        arr = num.toCharArray(); // 문자열을 문자 단위로 나눠 배열에 담습니다.

        int sum = 0; // 합계입니다.

        for(int i = 0; i < count; i++) { // 숫자 개수, 즉 배열의 길이 만큼 돌면서
            sum += Integer.parseInt(String.valueOf(arr[i])); // 문자를 숫자로 변환하여 더합니다.
        }
        System.out.println(sum); // 결과 출력
    }
}
