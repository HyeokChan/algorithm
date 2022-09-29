package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static PriorityQueue<Integer> pqueue = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                System.out.println(nvl(pqueue.poll(), 0));
            }
            else {
                pqueue.add(x);
            }
        }
    }
    public static Object nvl(Object o, int num){
        if(o == null){
            return num;
        }
        else {
            return o;
        }
    }
}
