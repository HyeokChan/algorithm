package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.poll();
            Integer temp = queue.poll();
            queue.add(temp);
        }
        System.out.println(queue.peek());
    }
}
