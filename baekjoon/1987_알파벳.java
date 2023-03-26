package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int r, c;
    public static char[][] board;
    public static int[][] visited;
    public static int max = Integer.MIN_VALUE;
    public static Set<Character> set = new HashSet<>();
    public static int[] dy = {-1,0,1,0};
    public static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        visited = new int[r][c];
        for(int i=0; i<r; i++){
            board[i] = br.readLine().toCharArray();
        }
        // 이미 등록된 알파벳 체크
        set.add(board[0][0]);
        visited[0][0] = 1;
        // 체크 시작
        movePoint(0,0);
        System.out.println(max);
    }
    // dfs로 체크
    public static void movePoint(int y, int x){
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= r || nx < 0 || nx >= c){
                continue;
            }
            else if(visited[ny][nx] !=0 || set.contains(board[ny][nx])){
                continue;
            }
            else {
                // 가능한 블럭 처리
                set.add(board[ny][nx]);
                visited[ny][nx] = visited[y][x]+1;
                movePoint(ny, nx);
            }
        }
        max = Math.max(max, visited[y][x]);
        // 방문처리 rollback
        visited[y][x] = 0;
        set.remove(board[y][x]);
    }
}