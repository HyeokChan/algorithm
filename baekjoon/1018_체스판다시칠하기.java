package com.company;
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static int N, M;
    public static int[][] board;
    public static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i=0; i<N; i++){
            char[] bws = br.readLine().toCharArray();
            for(int j=0; j<bws.length; j++){
                if(bws[j] == 'B'){
                    board[i][j] = 1;
                }
                else if(bws[j] == 'W'){
                    board[i][j] = 0;
                }
            }
        }
        //printBoard();
        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                int cnt = calcChangeBoard(new int[]{i,j});
                result = (cnt < result) ? cnt : result;
            }
        }
        System.out.println(result);
    }

    public static int calcChangeBoard(int[] startPoint){
        int wCnt = 0;
        int bCnt = 0;
        int targetBoard = 0;
        for (int i = startPoint[0]; i < startPoint[0] + 8; i++) {
            for (int j = startPoint[1]; j < startPoint[1] + 8; j++) {
                if(board[i][j] != targetBoard){
                    wCnt++;
                }
                targetBoard = (targetBoard + 1) % 2;
            }
            targetBoard = (targetBoard + 1) % 2;
        }
        targetBoard = 1;
        for (int i = startPoint[0]; i < startPoint[0] + 8; i++) {
            for (int j = startPoint[1]; j < startPoint[1] + 8; j++) {
                if(board[i][j] != targetBoard){
                    bCnt++;
                }
                targetBoard = (targetBoard + 1) % 2;
            }
            targetBoard = (targetBoard + 1) % 2;
        }
        return (wCnt < bCnt) ? wCnt : bCnt;
    }

    public static void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
