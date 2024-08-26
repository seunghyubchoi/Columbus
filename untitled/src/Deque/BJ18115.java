package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import java.io.*;

public class BJ18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        String str = br.readLine();
        String[] command = str.split(" ");
        for(int i=1; i<=n; i++){
            String num = command[n - i];
            switch(num){
                case "1":
                    deque.addFirst(i);
                    break;
                case "2":
                    int temp = deque.pollFirst();
                    deque.addFirst(i);
                    deque.addFirst(temp);
                    break;
                case "3":
                    deque.addLast(i);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(deque.pollFirst()).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}