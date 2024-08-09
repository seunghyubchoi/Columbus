package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class binaryToOctal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // int 범위를 넘게 수를 입력 받을 수도 있기 때문에 BigInteger로 받는다
        // 2를 넣어주면 받은 수를 2진수로 받게 된다.
        BigInteger num = new BigInteger(str, 2);
        // toString 사용 시 8을 넣어주면 8진수로 변환해준다.
        String result = num.toString(8);

        System.out.println(result);
    }
}
