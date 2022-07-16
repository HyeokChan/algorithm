package com.company;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] power;
    static int result = Integer.MAX_VALUE;
    static int[] source;
    static int[] out;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        power = new int[N][N];
        source = new int[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                power[i][j] = Integer.parseInt(st.nextToken());
            }
            // source 초기화
            source[i] = i;
        }
        int r = N / 2;
        out = new int[r];
        // 전체 조합 구하기
        combination(source, out, visited, 0, 0, r);

        System.out.println(result);
        //printPower();
    }

    // 조합
    public static void combination(int[] source, int[] out, boolean[] visited, int depth, int start, int r){
        if(depth == r){
            // 점수 계산
            calcValue();
            return;
        }
        for(int i=start; i<source.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = source[i];
                combination(source, out, visited, depth+1, i+1, r);
                visited[i] = false;
            }
        }
    }
    // 점수 계산
    public static void calcValue(){
        int firValue = 0;
        int secValue = 0;
        for(int i=0; i<N-1; i++){
            for(int j=i; j<N; j++){
                if(visited[i] == true && visited[j] == true){
                    firValue += power[i][j];
                    firValue += power[j][i];
                }
                if(visited[i] == false && visited[j] == false){
                    secValue += power[i][j];
                    secValue += power[j][i];
                }
            }
        }
        result = Math.min(result, Math.abs(firValue - secValue));
    }
    // 시너지 출력
    public static void printPower(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(power[i][j] + " ");
            }
            System.out.println();
        }
    }
}
