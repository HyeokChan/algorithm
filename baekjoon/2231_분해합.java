package com.company;
import java.io.*;

public class Main{
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0; i<N; i++){
            int temp = i;
            int sum = i;
            while (temp%10 > 0){
                sum += temp % 10;
                temp = temp / 10;
            }
            if(sum == N){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
