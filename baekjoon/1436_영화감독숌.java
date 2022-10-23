package com.company;
import java.io.*;

public class Main{
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int i = 666;
        int K = 1;
        while (K != N) {
            i++;
            if(Integer.toString(i).contains("666")){
                K++;
            }
        }
        System.out.println(i);
    }
}
