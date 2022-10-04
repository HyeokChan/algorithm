package com.company;
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static int N, K;
    public static int[] nums;
    public static int[] sorted;
    public static int result = -1;
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        // 입력받은 배열
        nums = new int[N];
        // 정렬된 배열
        sorted = new int[N];
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(nums, 0, nums.length-1);
        System.out.println(result);
    }
    public static void mergeSort(int[] nums, int left, int right){
        // left == right 가 되면 분할된 리스트의 크기가 하나라는 것
        if(left == right){
            return;
        }
        int mid = (left + right) / 2;
        // 양쪽 분할 재귀
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        // 병합
        merge(nums, left, mid, right);
    }
    public static void merge(int[] nums, int left, int mid, int right){
        // 왼쪽 리스트의 시작점
        int l = left;
        // 오른쪽 리스트의 시작점
        int r = mid + 1;
        // 채워넣을 인덱스
        int idx = 0;
        while (l <= mid && r <= right){
            if(nums[l] <= nums[r]){
                sorted[idx] = nums[l];
                l++;
            }
            else {
                sorted[idx] = nums[r];
                r++;
            }
            idx++;
        }
        // 왼쪽 리스트가 먼저 전부 다 채워졌으면 오른쪽 리스트 순차적으로 채움
        while (r <= right){
            sorted[idx++] = nums[r++];
        }
        // 오른쪽 리스트가 먼저 전부 다 채워졌으면 왼쪽 리스트 순차적으로 채움
        while (l <= mid){
            sorted[idx++] = nums[l++];
        }
        l = left;
        idx = 0;
        while (l <= right){
            cnt++;
            if(cnt == K){
                result = sorted[idx];
                break;
            }
            nums[l++] = sorted[idx++];
        }
    }
}
