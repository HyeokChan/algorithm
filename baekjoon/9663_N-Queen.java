package com.company;
import java.io.*;

public class Main{
    public static int N;
    public static int[] board;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        putQueen(0);
        System.out.println(result);

    }

    public static void putQueen(int row){
        if(row == N){
            result++;
            return;
        }
        for (int col = 0; col < N; col++) {
            board[row] = col;
            if(isOk(row, col)){
                putQueen(row+1);
            }
        }
    }

    public static boolean isOk(int row, int col){
        for(int i=0; i<row; i++){
            if(board[i] == col){
                return false;
            }
            if(Math.abs(i-row) == Math.abs(board[i]-col)){
                return false;
            }
        }
        return true;
    }
}
