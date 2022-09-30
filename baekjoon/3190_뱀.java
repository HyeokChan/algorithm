package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N, K, L;
    public static Deque<String> snake = new LinkedList<>();
    public static int[][] map;
    public static Map<Integer, String> dirChange = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            // 사과 위치
            map[y][x] = 1;
        }
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String change = st.nextToken();
            dirChange.put(time, change);
        }
        // 저장 끝

        // 결과시간
        int gameTime = 0;
        // 뱀의 초기 위치
        snake.addLast("0,0");
        // 나아가는 방향 상,우,하,좌
        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};
        int currDir = 1;
        while (true) {
            int ny = 0;
            int nx = 0;
            ny = Integer.parseInt(snake.peekLast().split(",")[0]) + dy[currDir];
            nx = Integer.parseInt(snake.peekLast().split(",")[1]) + dx[currDir];
            gameTime++;
            if (isGameOver(ny, nx)) {
                break;
            }
            // 뱀 위치 추가
            snake.addLast(ny+","+nx);
            // 사과 없으면 길이 줄이기
            if(map[ny][nx] == 1){
                map[ny][nx] = 0;
            }
            else {
                snake.pollFirst();
            }
            // 방향 전환 확인
            String handle = dirChange.getOrDefault(gameTime, "X");
            if(!"X".equals(handle)){
                // 왼쪽으로 90도 꺽음
                if("L".equals(handle)){
                    currDir = currDir - 1;
                    if(currDir == -1){
                        currDir = 3;
                    }
                }
                else if("D".equals(handle)){
                    currDir = (currDir + 1) % 4;
                }
            }
        }
        System.out.println(gameTime);
    }
    public static boolean isGameOver(int ny, int nx){
        if(ny < 0 || nx < 0 || ny >= N || nx >= N){
            return true;
        }
        if(snake.contains(ny+","+nx)){
            return true;
        }
        return false;
    }
}
