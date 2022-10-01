package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[] nums;
    public static int[] idxArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        int max = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
        idxArray = new int[max+1];
        for(int num : nums){
            idxArray[num]++;
        }
        for (int i = 0; i < idxArray.length; i++) {
            for (int j = 0; j < idxArray[i]; j++) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}
