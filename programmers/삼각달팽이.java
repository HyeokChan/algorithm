package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int[] answer = solution(n);
        Arrays.stream(answer).forEach(System.out::print);
    }

    public static int[] solution(int n) {
        // 2차원 리스트 생성 및 0 초기화
        ArrayList<ArrayList<Integer>> snail = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            ArrayList<Integer> snailLevel = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                snailLevel.add(0);
            }
            snail.add(snailLevel);
        }

        int curr = 1;
        int finish = 0; // 최종 도달 값
        for (int i = 0; i < n + 1; i++) {
            finish += i;
        }

        int y = -1;
        int x = 0;

        // 회전하면서 값 저장
        for (int i = n; i > 0; i -= 3) {
            for (int j = 0; j < i; j++) {   // 1 2 3 4
                y++;
                snail.get(y).set(x, curr);
                curr++;
            }
            for (int j = 0; j < i - 1; j++) {   // 5 6 7
                x++;
                snail.get(y).set(x, curr);
                curr++;
            }
            for (int j = 0; j < i - 2; j++) {   // 8 9
                y--;
                x--;
                snail.get(y).set(x, curr);
                curr++;
            }
        }

        // 1차원 배열 변환
        int[] answer = new int[finish];
        int idx=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < snail.get(i).size(); j++) {
                answer[idx++] = snail.get(i).get(j);
            }
        }
        return answer;
    }

}
