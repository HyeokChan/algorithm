package com.company;
import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int x, y;
    static int K;
    static int[][] map;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,1,-1,0};
    static int[] dice = new int[6];
    static boolean continueChk = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<K; j++){
            continueChk = false;
            int dir = Integer.parseInt(st.nextToken()) % 4;
            moveDice(dir);
            if(continueChk){
                continue;
            }
            System.out.println(dice[0]);
        }
    }
    public static void moveDice(int dir){
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx >= N || ny >= M || nx < 0 || ny < 0){
            continueChk = true;
            return;
        }
        changeDice(dir);
        int num = map[nx][ny];
        if(num == 0){
            map[nx][ny] = dice[5];
        }
        else {
            dice[5] = num;
            map[nx][ny] = 0;
        }
        x = nx; y = ny;
    }
    public static void changeDice(int dir){
        int[] temp = dice.clone();
        if(dir == 0){
            dice[0] = temp[4];
            dice[1] = temp[0];
            dice[4] = temp[5];
            dice[5] = temp[1];
        }
        else if(dir == 1){
            dice[0] = temp[3];
            dice[2] = temp[0];
            dice[3] = temp[5];
            dice[5] = temp[2];
        }
        else if(dir == 2){
            dice[0] = temp[2];
            dice[2] = temp[5];
            dice[3] = temp[0];
            dice[5] = temp[3];
        }
        else if(dir == 3){
            dice[0] = temp[1];
            dice[1] = temp[5];
            dice[4] = temp[0];
            dice[5] = temp[4];
        }
    }

}
