package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int result = 0;
    public static PriorityQueue<Integer> queue = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }
        // 최소힙으로 섞어야하는 대상 처리
        while (true){
            int a=0;
            int b=0;
            if(queue.peek() != null){
                a = queue.poll();
            }
            if(queue.peek() != null){
                b = queue.poll();
            } else {
                queue.add(a);
                break;
            }
            int t = a+b;
            result += t;
            queue.add(t);
        }
        System.out.println(result);
    }
}


