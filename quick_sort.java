package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        quick_sort(nums, 0, nums.length-1);
        for(int num : nums){
            sb.append(num + "\n");
        }
        System.out.println(sb);
    }
    public static void quick_sort(int[] nums, int start, int end){
        // 원소가 하나만 있으면 종료
        if(start >= end){
            return;
        }
        int pivot = start;
        int left = start + 1;
        int right = end;
        while (left <= right) {
            // 왼쪽부터 돌면서 피봇보다 큰 데이터를 찾을때까지 반복
            while (left <= end && nums[left] <= nums[pivot]) {
                left++;
            }
            // 오른쪽부터 돌면서 피봇보다 작은 데이터를 찾을때까지 반복
            while (right > start && nums[right] >= nums[pivot]) {
                right--;
            }
            // 엇갈리면 피봇과 작은 데이터 교환
            if(left > right){
                nums = swap(nums, pivot, right);
            }
            // 엇갈리지 않으면 작은 데이터와 큰 데이터 교환
            else {
                nums = swap(nums, right, left);
            }
        }
        quick_sort(nums, start, right - 1);
        quick_sort(nums, right + 1, end);
    }
    public static int[] swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
        return array;
    }
}
