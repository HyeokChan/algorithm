package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        int answer = solution(numbers, target);
        System.out.println("answer = " + answer);
    }

    public static int dfs(int prev, int[] numbers, int idx, int target) {
        // +/- 재귀를 배열의 마지막 수 까지 하고 다음 호출된 경우에
        // 이전 최종 금액이 target 과 같으면 1 return
        if (idx == numbers.length) {
            if (prev == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int ans = 0;
        ans += dfs(prev + numbers[idx], numbers, idx+1, target);
        ans += dfs(prev - numbers[idx], numbers, idx+1, target);
        // 재귀 return 으로 최종 값 0 또는 1 반환
        return ans;
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int curr = 0;
        // 0부터 시작해서 numbers[0] 부터 +/- 재귀
        // 모든 경우의 수의 return 값 더하기
        answer += dfs(curr, numbers, 0, target);
        return answer;
    }
}
