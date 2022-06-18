package com.company;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dxSet;
    static int[][] dySet;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dxSet = new int[][]{{0,0,0},{1,2,3},
                            {0,1,1},
                            {1,2,2},{1,2,2} ,{0,1,2},{0,1,2},{1,1,1},{1,1,1}  ,{0,0,1},{0,0,1},
                            {1,1,2},{1,1,2},  {0,1,1} ,{0,1,1},
                            {0,0,1},{1,1,1}, {1,1,2},{1,1,2}};
        dySet = new int[][]{{1,2,3},{0,0,0},
                            {1,0,1},
                            {0,0,1},{0,-1,0},{1,0,0},{1,1,1},{0,1,2},{-2,-1,0},{1,2,0},{1,2,2},
                            {0,1,1},{-1,0,-1},{1,-1,0},{1,1,2},
                            {1,2,1},{-1,0,1},{0,1,0},{-1,0,0}};

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                calcVal(i, j);
            }
        }

        System.out.println(max);
    }

    public static void calcVal(int x, int y){
        for(int i=0; i<dxSet.length; i++){
            int sum = 0;
            sum += map[x][y];
            for(int j=0; j<dxSet[0].length; j++){
                int nx = x + dxSet[i][j];
                int ny = y + dySet[i][j];
                if(nx >= N || ny >= M || nx < 0 || ny < 0){
                    continue;
                }
                sum += map[nx][ny];
            }
            if(sum >= max){
                max = sum;
            }
        }
    }
}
