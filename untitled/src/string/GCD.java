package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 공백 기준으로 나눠 담기
        int a = Integer.parseInt(st.nextToken()); // st 첫 번째 담은 수를 변수 a에 담기
        int b = Integer.parseInt(st.nextToken()); // st 두 번째 담은 수를 변수 b에 담기

        int c = (gcd(a,b));

        System.out.println(c); // 최대공약수
        System.out.println((a*b)/c); // a와 b를 곱한 값을 최대공약수로 나눔

    }

    public static int gcd(int a, int b){
        while(b != 0){ // 나누는 수가 0이 될 때까지만 반복
            int r = a % b; // 나머지 값
            a = b; // 나누는 수를 나눠지는 수에 담기
            b = r; // 나머지를 나누는 수에 담기
        }

        return a; // 나누는 수가 0 일 때 나눠지는 수 리턴
    }
}

