package com.company;
import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 796796;
        }
        System.out.println(dp[N]);
    }
}
