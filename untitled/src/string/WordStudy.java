package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordStudy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase(); // 대문자 입출력을 위한 대문자 선언
        int[] count = new int[26]; // 알파벳 자릿 수 만큼 int 배열 선언

        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'A']++; // 'A'와 계산하여 해당 알파벳의 인덱스 수 증가
        }

        int max = 0; // 가장 큰 인덱스의 수를 찾기 위한 변수
        int cnt = 0; // 중복된 인덱스를 찾기 위한 변수

        for (int i = 0; i < count.length; i++) {
            if(count[i] > count[max]) { // 기존의 인덱스보다 큰 인덱스를 만나면
                max = i; // max에 자릿 수를 담아준다
            }
        }

        for(int i = 0; i < count.length; i++) {
            if(count[max] == count[i]){ // 가장 큰 수의 인덱스가 여러 개 라면
                cnt++; // cnt는 2 이상이 될 것
            }
        }

        char result = cnt > 1 ? '?' : (char)('A' + max); // 가장 큰 수의 인덱스가 중복이면 ? 아니면 문자
        System.out.println(result);

    }
}
