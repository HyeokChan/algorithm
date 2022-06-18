package com.company;
import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] map;
    static int count = 0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            map[N][i] = Integer.parseInt(st.nextToken());
        }
        while (calcDiff() > K){
            count++;
            addFish();
            roll();
            calcFish();
            flatMap();
            fold();
            calcFish();
            flatMap();
            //printMap(map);
        }
        System.out.println(count);

    }


    public static void fold(){
        List<Integer> list = new ArrayList<>();
        int pivot = 1;
        int yCnt = 1;
        for (int cnt = 1; cnt <= 2; cnt++) {
            int _y= N - yCnt * 2 + 1;
            for (int y = N; y > N-yCnt; y--) {
                list.clear();
                for (int x = pivot; x < pivot +(N - pivot + 1) / 2; x++) {
                    list.add(map[y][x]);
                    map[y][x]=0;
                }
                for(int idx=0;idx<list.size();idx++) {
                    map[_y][N-idx]=list.get(idx);
                }
                _y++;
            }
            yCnt *= 2;
            pivot += N / 2;
        }


    }

    public static void flatMap(){
        int[] flatArray = new int[N+1];
        int idx = 1;
        for(int x=1; x<=N; x++){
            for(int y=N; y>=1; y--){
                if(map[y][x] != 0){
                    flatArray[idx] = map[y][x];
                    idx++;
                }
            }
        }
        map = new int[N+1][N+1];
        map[N] = flatArray.clone();
    }

    public static void calcFish(){
        int[][] calcMap = new int[N+1][N+1];
        for(int y=1; y<=N; y++){
            for(int x=1; x<=N; x++){
                if(map[y][x] == 0){
                    continue;
                }
                for(int d=0; d<4; d++){
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if(ny > N || nx > N || ny < 0 || nx < 0){
                        continue;
                    }
                    if(map[ny][nx] == 0){
                        continue;
                    }
                    int diff = (map[y][x] - map[ny][nx]) / 5;
                    // (y,x)에서 (ny,nx)로 물고기 준다
                    if(diff > 0){
                        calcMap[y][x] -= diff;
                        calcMap[ny][nx] += diff;
                    }
                }
            }
        }
        for(int y=1; y<=N; y++){
            for(int x=1; x<=N; x++){
                map[y][x] += calcMap[y][x];
            }
        }
    }

    public static void roll(){
        int pivot = 1;
        int w = 1;
        int h = 1;
        int idx = 0;
        while (pivot-1 + w + h <= N){
            idx++;
            for(int x=pivot; x<pivot+w; x++){
                for(int y=N; y>N-h; y--){
                    int ny = N-w+x-pivot;
                    int nx = pivot+w+N-y;
                    map[ny][nx] = map[y][x];
                    map[y][x] = 0;
                }
            }
            pivot += w;
            if(idx%2 == 0){
                w++;
            } else {
                h++;
            }
        }
    }

    public static void addFish(){
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++){
            min = Math.min(map[N][i], min);
        }
        for(int i=1; i<=N; i++){
            if(map[N][i] == min){
                map[N][i]++;
            }
        }
    }

    public static int calcDiff(){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++){
            max = Math.max(map[N][i], max);
            min = Math.min(map[N][i], min);
        }
        return max - min;
    }

    public static void printMap(int[][] map){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
