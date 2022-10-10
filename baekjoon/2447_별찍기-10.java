package com.company;
import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static char[][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        star = new char[N][N];
        int[] startPoint = new int[]{0, 0};
        makeStar(N, startPoint);
        sb = printStar(sb);
        System.out.println(sb);
    }

    public static void makeStar(int N, int[] startPoint) {
        // 종료조건
        if(N < 3){
            return;
        }
        // 3(최소단위)이면 시작점 기준으로 그린다.
        else if(N == 3){
            drawStar(startPoint);
        }
        // 시작점 생성
        List<int[]> startPointList = makeStartPoint(N, startPoint);
        for(int[] nextStartPoint : startPointList){
            makeStar(N/3, nextStartPoint);
        }
    }
    // 시작점 생성 메소드
    public static List<int[]> makeStartPoint(int N, int[] startPoint){
        List<int[]> startPointList = new ArrayList<>();
        int unitNum = N / 3;
        for(int i=0; i<=unitNum*2; i+=unitNum){
            for(int j=0; j<=unitNum*2; j+=unitNum){
                if(i == unitNum && j == unitNum){
                    continue;
                }
                startPointList.add(new int[]{startPoint[0]+i, startPoint[1]+j});
            }
        }
        return startPointList;
    }
    // 별표 표시
    public static void drawStar(int[] startPoint) {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1){
                    continue;
                }
                star[startPoint[0]+i][startPoint[1]+j] = '*';
            }
        }
    }
    // 최종값 출력
    public static StringBuilder printStar(StringBuilder sb){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(star[i][j] == '*'){
                    sb.append("*");
                }
                else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb;
    }
}
