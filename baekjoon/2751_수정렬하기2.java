package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for(int num : list){
            sb.append(num + "\n");
        }
        System.out.println(sb);
    }
}
