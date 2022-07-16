package com.company;
import java.util.*;
import java.io.*;
public class Main {
    static int N, M, B;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int min = Arrays.stream(matrix).flatMapToInt(temp -> Arrays.stream(temp)).min().orElse(Integer.MAX_VALUE);
        int max = Arrays.stream(matrix).flatMapToInt(temp -> Arrays.stream(temp)).max().orElse(Integer.MIN_VALUE);

        int resultTime = Integer.MAX_VALUE;
        int resultFloor = -1;

        // i : 만들고자하는 높이
        for(int i=min; i<=max; i++){
            int time = 0;
            int inven = B;
            for(int r=0; r<N; r++){
                for(int c=0; c<M; c++){
                    if(matrix[r][c] > i){
                        // 벽돌 치우기
                        int diff = matrix[r][c] - i;
                        inven += diff;
                        // 치우는 시간 증가
                        time += diff * 2;
                    }
                    if(matrix[r][c] < i){
                        // 벽돌 쌓기
                        int diff = i - matrix[r][c];
                        inven -= diff;
                        // 쌓는 시간 증가
                        time += diff;
                    }
                }
            }
            // 전부 계산했을때, 인벤토리 블럭 개수가 음수이면 안됨
            if(inven >= 0){
                if(time <= resultTime){
                    resultTime = time;
                    resultFloor = i;
                }
            }
        }

        System.out.println(resultTime + " " + resultFloor);

    }
}
