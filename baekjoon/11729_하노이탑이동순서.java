package com.company;
import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static List<int[]> moveList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 2, 3);
        printMoveList();
    }

    public static void hanoi(int N, int start, int mid, int to) {
        if(N == 1){
            moveList.add(new int[]{start, to});
            return;
        }
        hanoi(N-1, start, to, mid);
        moveList.add(new int[]{start, to});
        hanoi(N-1, mid, start, to);
    }

    public static void printMoveList(){
        StringBuilder sb = new StringBuilder();
        System.out.println(moveList.size());
        for(int[] temp : moveList){
            sb.append(temp[0] + " " + temp[1] + "\n");
        }
        System.out.println(sb);
    }
}
