package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] board;
    public static Robot robot;
    public static int result = 0;
    public static int dy[] = {-1,0,1,0};
    public static int dx[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        st = new StringTokenizer(br.readLine());
        robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        moveRobot();
        System.out.println(result);
    }

    public static void moveRobot(){
        while (true){
            // 현재 칸이 청소되지 않은 경우 현재 칸 청소
            if(board[robot.y][robot.x] == 0){
                board[robot.y][robot.x] = -1;
                result++;
            }
            // 주위 4칸 중 청소되지 않은 칸이 있는 경우
            if(robot.isTrash()){
                robot.rotate();
                robot.go();
            }
            // 주위 4칸 모두 청소된 경우
            else {
                // 후진 가능여부 체크
                boolean b = robot.isBack();
                if(!b){
                    break;
                }
            }
        }
    }

    public static class Robot {
        int y;
        int x;
        int d;
        public Robot(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
        // 주위 4칸 체크
        public boolean isTrash(){
            for(int i=0; i<4; i++){
                if(this.y+dy[i]<0 || this.y+dy[i]>=n || this.x+dx[i]<0 || this.x+dx[i]>=m){
                    continue;
                }
                if(board[this.y+dy[i]][this.x+dx[i]] == 0){
                    return true;
                }
            }
            return false;
        }
        // 반시계방향 회전
        public void rotate(){
            this.d--;
            if(this.d == -1){
                this.d = 3;
            }
        }
        // 앞 칸이 청소되지 않은 빈칸인 경우 전진
        public void go(){
            int ny = this.y + dy[this.d];
            int nx = this.x + dx[this.d];
            if(ny<0 || ny>=n || nx<0 || nx>=m || board[ny][nx]!=0){
                return;
            }
            this.y = ny;
            this.x = nx;
        }
        // 후진 가능여부 체크
        public boolean isBack(){
            int ny = this.y - dy[this.d];
            int nx = this.x - dx[this.d];
            if(ny<0 || ny>=n || nx<0 || nx>=m || board[ny][nx]==1){
                return false;
            }
            this.y = ny;
            this.x = nx;
            return true;
        }
    }
}
