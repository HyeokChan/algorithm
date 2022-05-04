package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                             {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                             {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                             {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                             {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer = solution(places);
        Arrays.stream(answer).forEach(System.out::println);
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        boolean breakChk = false;
        Arrays.fill(answer, 1);
        // 반복문 돌면서 p확인
        for (int i = 0; i < places.length; i++) {
            breakChk = false;
            for (int j = 0; j < places[0].length; j++) {
                for (int k = 0; k < 5; k++) {
                    if(places[i][j].charAt(k) == 'P'){
                        int result = bfs(places[i], j, k);
                        answer[i] = result;
                        if(result == 0){
                            breakChk = true;
                            break;
                        }
                    }
                }
                if (breakChk) {
                    break;
                }
            }
        }
        return answer;
    }

    public static int bfs(String[] trgtPlace, int j, int k){
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{j, k});
        while (!queue.isEmpty()) {
            int[] trgtXY = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = trgtXY[0] + dy[i];
                int nextX = trgtXY[1] + dx[i];
                if(nextY < 0 || nextY > 4 || nextX < 0 || nextX > 4 || (nextY == j && nextX == k)){
                    continue;
                }
                int md = Math.abs(nextY - j) + Math.abs(nextX - k);
                if (trgtPlace[nextY].charAt(nextX) == 'P' && md <= 2) {
                    return 0;
                }
                else if(trgtPlace[nextY].charAt(nextX) == 'O' && md < 2){
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
        return 1;
    }

}
