package com.company;
import java.util.*;
import java.io.*;
public class Main {
    static int[] board;
    static int N;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        dfs(0);
        System.out.print(result);
    }
    public static void dfs(int row){
        if(row == N){
            result++;
            return;
        }
        for(int i=0; i<N; i++){
            board[row] = i;
            // 가능 하면 재귀 호출, 조건문으로 가지치기 (백트래킹)
            if(isOk(row)){
                dfs(row+1);
            }
        }
    }
    public static boolean isOk(int col){
        for(int j=0; j<col; j++){
            if(board[col] == board[j]){
                return false;
            }
            else if(Math.abs(board[col] - board[j]) == Math.abs(col - j)){
                return false;
            }
        }
        return true;
    }
}
