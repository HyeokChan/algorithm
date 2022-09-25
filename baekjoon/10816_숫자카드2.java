package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] cards;
    public static int[] targets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 초기화
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(cards);
        StringBuilder sb = new StringBuilder();
        for(int target : targets){
            // 이분 탐색, lower_bound / upper_bound
            int dupCnt = upperBound(target) - lowerBound(target);
            sb.append(dupCnt + " ");
        }
        System.out.println(sb );
    }
    public static int lowerBound(int target){
        int start = 0;
        int end = cards.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if(cards[mid] >= target){
                end = mid;
            }
            else if(cards[mid] < target){
                start = mid + 1;
            }
        }
        return start;
    }
    public static int upperBound(int target){
        int start = 0;
        int end = cards.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if(cards[mid] > target){
                end = mid;
            }
            else if(cards[mid] <= target){
                start = mid + 1;
            }
        }
        return start;
    }
}
