package com.company;
import java.io.*;

public class Main{
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int result = pivo(N);
        System.out.println(result);
    }
    public static int pivo(int n){
        if(n == 1){
            return 1;
        }
        else if(n == 0){
            return 0;
        }
        else {
            return pivo(n - 1) + pivo(n - 2);
        }
    }
}
