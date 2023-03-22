package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dy = {-1,0,1,0};
    public static int[] dx = {0,1,0,-1};
    public static int cnt = 0;
    public static int max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    checkBoard(i, j);
                    // 그림의 개수 증가
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    // BFS 처리
    public static void checkBoard(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int curr = 1;
        while (!queue.isEmpty()){
            int[] tPoint = queue.poll();
            int y = tPoint[0];
            int x = tPoint[1];
            for(int idx=0; idx<4; idx++){
                int ny = y + dy[idx];
                int nx = x + dx[idx];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] || board[ny][nx] == 0){
                    continue;
                }
                visited[ny][nx] = true;
                // 그림 최대 크기 계산하기 위해
                curr++;
                queue.add(new int[]{ny, nx});
            }
        }
        max = Math.max(max, curr);
    }
}


