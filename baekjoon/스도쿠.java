package com.company;
import java.util.*;
import java.io.*;
public class Main {
    static int[][] board = new int[9][9];
    static int[] target = new int[]{1,2,3,4,5,6,7,8,9};
    static boolean breakPoint = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        putNumber(0, 0);
        //printBoard();
    }
    public static void putNumber(int row, int col){
        if(col == 9){
            putNumber(row + 1, 0);
            return;
        }
        if(row == 9){
            printBoard();
            System.exit(0);
        }
        // 빈 곳이면
        if(board[row][col] == 0){
            // 1 ~ 9 까지 수를 넣었을 때 가능한지 체크
            for(int num : target){
                if(isOk(row, col, num)){
                    board[row][col] = num;
                    putNumber(row, col+1);
                }
            }
            board[row][col] = 0;
            return;
        }
        putNumber(row, col+1);
    }
    // 행에 0이 하나도 없는지 체크
    public static boolean chkRowZero(int row){
        for(int i=0; i<9; i++){
            if(board[row][i] == 0){
                return false;
            }
        }
        return true;
    }
    // 1 ~ 9 를 넣었을 때 가능한지 체크
    public static boolean isOk(int row, int col, int num){
        // 행검사
        for(int i=0; i<9; i++){
            if(board[row][i] == num){
                return false;
            }
        }
        // 열검사
        for(int i=0; i<9; i++){
            if(board[i][col] == num){
                return false;
            }
        }
        // 3x3 검사
        int tRow = (row / 3) * 3;
        int tCol = (col / 3) * 3;
        for(int i=tRow; i<tRow+3; i++){
            for(int j=tCol; j<tCol+3; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }

    // 스도크 보드 출력
    public static void printBoard() {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
