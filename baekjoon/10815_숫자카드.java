package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] nums;
    public static int[] targets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        for (int target : targets) {
            if(binarySearch(target)){
                sb.append("1 ");
            }
            else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int target){
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(target < nums[mid]){
                end = mid - 1;
            }
            else if(target > nums[mid]){
                start = mid + 1;
            }
            else if(nums[mid] == target){
                return true;
            }
        }
        return false;
    }
}
