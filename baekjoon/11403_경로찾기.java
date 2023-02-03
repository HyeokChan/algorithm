package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static int n;
    public static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }
        // 플로이드와샬
        // 거쳐가는 정점
        for(int k=0; k<n; k++){
            // 시작점
            for(int i=0; i<n; i++){
                // 도착점
                for(int j=0; j<n; j++){
                    if(board[i][k]==1 && board[k][j]==1){
                        board[i][j] = 1;
                    }
                }
            }
        }
        printResult();
    }

    public static void printResult(){
        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}


