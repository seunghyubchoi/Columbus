package stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class QueueImpl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    Integer number = queue.poll();
                    if (number == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(number).append('\n');
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if(queue.isEmpty()) {
                        sb.append(1).append('\n');
                    }
                    else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    Integer peekNum = queue.peek();
                    if (peekNum == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(peekNum).append('\n');
                    }
                    break;
                case "back":
                    Integer peekLast = queue.peekLast();
                    if (peekLast == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(peekLast).append('\n');
                    }
            }
        }
        System.out.println(sb);
    }
}
