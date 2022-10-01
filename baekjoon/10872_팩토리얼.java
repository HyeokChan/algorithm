package com.company;
import java.io.*;

public class Main{
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int result = pacto(N);
        System.out.println(result);
    }

    public static int pacto(int num) {
        if(num == 1 || num == 0){
            return 1;
        }
        else {
            return num * pacto(num - 1);
        }
    }
}
