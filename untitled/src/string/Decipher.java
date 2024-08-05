package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Decipher {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++){

            int[] arr = new int[26]; // 알파벳 26개의 빈도수 확인을 위한 배열
            String sentence = br.readLine(); // 입력 받을 문자열
            char[] charArr = sentence.toCharArray(); // 입력 받은 문자열을 문자 배열로 만들기
            int max = 0; // 최다 인덱스 번호
            int cnt = 0; // 같은 횟수인 경우 ++ 해줄 변수

            for(int j = 0; j < charArr.length; j++) {
                if(charArr[j] >= 'a' && charArr[j] <= 'z') { //
                    arr[charArr[j] - 'a']++;
                }
            }

            for(int j = 0; j < arr.length; j++) {
                if(arr[max] < arr[j]){
                    max = j;
                }
            }

            for(int j = 0; j < arr.length; j++) {
                if(arr[max] == arr[j]){
                    cnt++;
                }
            }

            char answer = cnt > 1 ? '?' : (char)(97 + max);
            System.out.println(answer);
        }
    }
}
