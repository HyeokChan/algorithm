package com.company;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
    static int N;
    static int[][] map;
    static int[][] temp;
    static int[] direct;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        // 0:상, 1:하, 2:좌, 3:우
        direct = new int[5];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dfs 로 모든 방향 조합에 대해 체크
        dfs(5, 0);

        System.out.print(max);

    }

    public static void dfs(int end, int index){
        if(index == end){
            // 점수 확인
            confirm();
        }
        else {
            for(int i=0; i<4; i++){
                direct[index] = i;
                dfs(end, index+1);
            }
        }
    }

    public static void confirm(){
        // 방향 조합 확인 전 초기화 (깊은복사)
        temp = new int[N][N];
        for(int i=0; i<N; i++){
            temp[i] = map[i].clone();
        }

        for(int d=0; d<direct.length; d++){
            visited = new boolean[N][N];
            // 상 방향
            if(direct[d] == 0){
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        // 각 요소 하나하나 이동 시킴
                        move(i, j, direct[d]);
                    }
                }
            }
            // 하 방향
            if(direct[d] == 2){
                // 밑에서 부터 당김
                for(int i=N-1; i>-1; i--){
                    for(int j=0; j<N; j++){
                        move(i, j, direct[d]);
                    }
                }
            }
            // 우 방향
            if(direct[d] == 1){
                for(int i=N-1; i>-1; i--){
                    for(int j=0; j<N; j++){
                        move(j, i, direct[d]);
                    }
                }
            }
            // 좌 방향
            if(direct[d] == 3){
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        move(j, i, direct[d]);
                    }
                }
            }
        }
        // max 값 갱신
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(temp[i][j] >= max){
                    max = temp[i][j];
                }
            }
        }
    }

    public static void move(int x, int y, int dir){
        // 0은 합칠 필요 없음
        if(temp[x][y] == 0){
            return;
        }
        // 합쳐야할 대상이 0인 경우 반복하기 위해
        while (true) {
            // nx, ny 합쳐질 기준점
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                return;
            }
            if(visited[nx][ny]){
                return;
            }
            // 같으면 합치기
            if(temp[nx][ny] == temp[x][y]){
                visited[nx][ny] = true;
                temp[nx][ny] += temp[x][y];
                temp[x][y] = 0;
                return;
            }
            // 0이 아니고 다른 수면 못합침
            else if(temp[nx][ny] != 0) {
                return;
            }
            // 0인 경우 한 칸 당기고 반복
            else if(temp[nx][ny] == 0){
                temp[nx][ny] = temp[x][y];
                temp[x][y] = 0;
                x = nx;
                y = ny;
            }
        }
    }
}
