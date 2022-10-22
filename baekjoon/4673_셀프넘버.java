package com.company;
import java.io.*;

public class Main{
    public static int[] nums = new int[10001];
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            int dn = calcDn(i);
            if(dn <= 10000){
                nums[dn] = i;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == 0){
                sb.append(i + "\n");
            }
        }
        System.out.print(sb);
    }

    public static int calcDn(int i){
        int sum = i;
        while (i > 0){
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}
