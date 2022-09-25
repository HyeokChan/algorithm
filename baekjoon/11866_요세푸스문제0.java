package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N, K;
    public static ArrayList<Integer> nums = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            nums.add(i);
        }
        K = Integer.parseInt(st.nextToken());
        int numsIdx = -1;
        int removeIdx = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (nums.size() != 0) {
            numsIdx++;
            removeIdx++;
            if(numsIdx == nums.size()){
                numsIdx = 0;
            }
            if(removeIdx == K){
                sb.append(nums.get(numsIdx) + ", ");
                nums.remove(numsIdx);
                numsIdx--;
                removeIdx = 0;
            }
        }
        String result = sb.substring(0, sb.length() - 2);
        result = result + ">";
        System.out.println(result);
    }
}
