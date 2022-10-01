package com.company;
import java.util.*;
import java.io.*;

public class Main{
    public static String N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = br.readLine();
        String[] nums = N.split("");
        Arrays.sort(nums, Collections.reverseOrder());
        for(String num : nums){
            sb.append(num);
        }
        System.out.println(sb);
    }
}
