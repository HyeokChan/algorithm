package com.company;
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int L;
    static int[][] map;
    static int[][] visit;
    static int snakeLen = 1;
    static int currTime = 0;
    static int totTime = 0;
    static int headX = 0;
    static int headY = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int dirIndex = 1;
    static boolean breakChk = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new int[N][N];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            map[x][y] = 99;
        }
        visit[headX][headY] = 1;

        L = Integer.parseInt(br.readLine());
        String dir = "";
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            dir = st.nextToken();
            move(time, dir);
            if(breakChk){
                break;
            }
        }
        // 마지막 방향 쭉 이동
        if(!breakChk){
            move(Integer.MAX_VALUE, dir);
        }
        System.out.println(totTime);
    }
    public static void move(int time, String dir){
        int moveTime = time - currTime;
        //System.out.println("moveTime = " + moveTime);
        for(int i=1; i<=moveTime; i++){
            headX = headX+dx[dirIndex];
            headY = headY+dy[dirIndex];
            if(headX >= N || headY>=N || headX < 0 || headY < 0){
                totTime++;
                breakChk = true;
                return;
            }
            if(visit[headX][headY] != 0){
                totTime++;
                breakChk = true;
                return;
            }
            totTime++;
            int next = map[headX][headY];
            // 다음 위치가 사과면 뱀 길이 더하기
            if(next == 99){
                snakeLen++;
                visit[headX][headY] = snakeLen;
                // 먹은 사과 초기화
                map[headX][headY] = 0;
            }
            else {
                changeVisit();
                visit[headX][headY] = snakeLen;
            }
        }
        currTime = time;
        // 방향 전환
        changeDir(dir);
    }
    public static void changeVisit(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int visitValue = visit[i][j];
                if(visitValue != 0){
                    visit[i][j] -= 1;
                }
            }
        }
    }
    public static void changeDir(String dir){
        if(dirIndex == 0){
            if(dir.equals("D")){
                dirIndex = 1;
            }
            else if(dir.equals("L")){
                dirIndex = 3;
            }
        }
        else if(dirIndex == 1){
            if(dir.equals("D")){
                dirIndex = 2;
            }
            else if(dir.equals("L")){
                dirIndex = 0;
            }
        }
        else if(dirIndex == 2){
            if(dir.equals("D")){
                dirIndex = 3;
            }
            else if(dir.equals("L")){
                dirIndex = 1;
            }
        }
        else if(dirIndex == 3){
            if(dir.equals("D")){
                dirIndex = 0;
            }
            else if(dir.equals("L")){
                dirIndex = 2;
            }
        }
    }
}
