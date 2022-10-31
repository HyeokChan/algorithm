package com.company;
import java.io.*;
import java.util.*;

public class Main{
    public static int n;
    public static int[] f;
    public static int recCnt = 0;
    public static int dnCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        f = new int[n+1];
        fib(n);
        fibonacci(n);
        System.out.println(recCnt + " " + dnCnt);
    }
    public static int fib(int n){
        if(n == 1 || n == 2){
            recCnt++;
            return 1;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    public static int fibonacci(int n) {
        f[1] = 1;
        f[2] = 1;
        for(int i=3; i<=n; i++){
            dnCnt++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
