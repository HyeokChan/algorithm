package com.company;
import java.io.*;

public class Main{
    public static int N;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (isHan(i)) {
                result++;
            }
        }
        System.out.println(result);
    }
    public static boolean isHan(int i){
        int difNum = Integer.MAX_VALUE;
        int currNum = -1;
        while (i > 0) {
            int num = i % 10;
            if(currNum == -1){
                currNum = num;
            }
            else {
                if(difNum == Integer.MAX_VALUE){
                    difNum = currNum - num;
                    currNum = num;
                }
                else {
                    int temp = currNum - num;
                    if(difNum != temp){
                        return false;
                    }
                    else {
                        currNum = num;
                    }
                }
            }
            i = i / 10;
        }
        return true;
    }
}
