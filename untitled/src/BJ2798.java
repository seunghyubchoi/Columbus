import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(result(M, arr));
    }

    static int result(int targetValue, int[] array) {
        int result = 0;

        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {

                    int tmp = array[i] + array[j] + array[k];

                    if (targetValue == tmp) {
                        return tmp;
                    }

                    if (result < tmp && tmp < targetValue) {
                        result = tmp;
                    }

                }
            }
        }
        return result;
    }
}
