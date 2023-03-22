package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static int[] points = new int[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        // 내 위치 이동
        moveN();
        System.out.println(points[k]);

    }

    // 내 위치 이동
    public static void moveN(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()){
            int curr = queue.poll();
            if(curr == k){
                return;
            }
            // 반복문 순서 중요, 순간이동은 비용이 0
            for(int t : new int[]{curr*2, curr-1, curr+1}){
                if(t > 100000 || t < 0 || points[t] != 0){
                    continue;
                }
                if(t == curr*2){
                    points[t] = points[curr];
                }
                else {
                    points[t] = points[curr]+1;
                }
                queue.add(t);
            }
        }
    }
}


