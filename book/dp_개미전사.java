package com.company;
import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static int[] gros;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        gros = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gros[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = gros[0];
        dp[1] = Math.max(gros[0], gros[1]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + gros[i], dp[i - 1]);
        }
        System.out.println(dp[N-1]);
    }
}
