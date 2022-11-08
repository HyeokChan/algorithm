package com.company;
import java.io.*;
import java.util.*;

public class Main{
    public static int N, M;
    public static int[] dp;
    public static ArrayList<Integer> nums = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[10001];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            dp[num] = 1;
            nums.add(num);
        }
        // 내림차순 정렬
        Collections.sort(nums, Collections.reverseOrder());
        int minNum = nums.get(nums.size() - 1);
        for (int i = minNum + 1; i <= M; i++) {
            // 이미 채워진 값이 있으면 제외, 채워지지 않은 값만 처리
            if(dp[i] == 0){
                // 화폐 단위 순회 (큰 가치화폐 부터)
                for(int j=0; j<nums.size(); j++){
                    int idx = i - nums.get(j);
                    // 큰 가체 화폐를 뺀 금액을 구할 수 없으면 다음 단위 가치화폐로 비교
                    if(idx < 0 || dp[idx] == 0){
                        continue;
                    }
                    // 가치화폐 1개 추가
                    dp[i] = dp[idx] + 1;
                    break;
                }
            }
        }
        if(dp[M] == 0){
            System.out.println(-1);
        }
        else {
            System.out.println(dp[M]);
        }
    }
}
