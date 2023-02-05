package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] board;
    public static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        // 초기화
        board = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 이미 다익은 토마토인지 체크
        if(checkPreTomato()){
            result = 0;
        }
        else {
            bfs();
            // 안익은 토마토 체크
            if(checkPostTomato()){
                result = -1;
            }
            else {
                int max = Integer.MIN_VALUE;
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        if(board[i][j] != -1 && board[i][j] > max){
                            max = board[i][j];
                        }
                    }
                }
                result = max-1;
            }
        }
        System.out.println(result);
    }

    // 토마토 익히기
    public static void bfs(){
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        // 처음 익은 토마토 저장
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        // bfs진행
        while (!queue.isEmpty()){
            int[] t = queue.poll();
            int y = t[0];
            int x = t[1];
            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny<0 || ny>=n || nx<0 || nx >=m || board[ny][nx] != 0){
                    continue;
                }
                // 경과 시간 체크를 위해
                board[ny][nx] = board[y][x]+1;
                queue.add(new int[]{ny,nx});
            }
        }
    }

    // 이미 다익은 토마토인지 체크
    public static boolean checkPreTomato(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    // 안익은 토마토 체크
    public static boolean checkPostTomato(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
