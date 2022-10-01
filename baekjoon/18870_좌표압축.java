package com.company;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main{
    public static int N;
    public static int[] nums;
    public static List<Integer> list;
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
        int[] temp = nums.clone();
        list = Arrays.stream(temp).boxed().collect(Collectors.toSet()).stream().collect(Collectors.toList());
        Collections.sort(list);
        for (int num : nums) {
            int idx = binarySearch(list, num);
            //int idx = Collections.binarySearch(list, num);
            sb.append(idx + " ");
        }
        System.out.println(sb);
    }

    public static int binarySearch(List<Integer> list, int num){
        int start = 0;
        int end = list.size() - 1;
        int mid = 0;
        while (start <= end){
            mid = (start + end) / 2;
            if(list.get(mid) == num){
                return mid;
            }
            else if(list.get(mid) < num){
                start = mid + 1;
            }
            else if(list.get(mid) > num){
                end = mid - 1;
            }
        }
        return mid;
    }
}
