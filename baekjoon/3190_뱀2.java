package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n, k, l;
    public static int[][] board;
    public static Deque<int[]> snake = new LinkedList<>();
    public static int totTime = 0;
    public static int[] dy = {-1,0,1,0};
    public static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            String s = br.readLine();
            int y = Integer.parseInt(s.split(" ")[0])-1;
            int x = Integer.parseInt(s.split(" ")[1])-1;
            // 사과의 위치
            board[y][x] = 1;
        }
        l = Integer.parseInt(br.readLine());
        snake.addLast(new int[]{0,0});
        int dir = 1;
        Deque<String[]> deque = new LinkedList<>();
        for(int i=0; i<l; i++){
            deque.addLast(br.readLine().split(" "));
        }
        while (true){
            int y = snake.peekLast()[0] + dy[dir];
            int x = snake.peekLast()[1] + dx[dir];
            totTime++;
            if(isOver(y, x)){
                System.out.println(totTime);
                return;
            }
            if(board[y][x] == 1){
                snake.addLast(new int[]{y, x});
                board[y][x] = 0;
            }
            else {
                snake.addLast(new int[]{y, x});
                snake.pollFirst();
            }
            if(!deque.isEmpty()){
                if(deque.peekFirst()[0].equals(Integer.toString(totTime))){
                    String stDir = deque.peekFirst()[1];
                    if("L".equals(stDir)){
                        dir-=1;
                        if(dir == -1){
                            dir = 3;
                        }
                    }
                    if("D".equals(stDir)){
                        dir+=1;
                        if(dir == 4){
                            dir = 0;
                        }
                    }
                    deque.pollFirst();
                }
            }
        }
    }

    public static boolean isOver(int y, int x){
        if(y < 0 || y >=n || x < 0 || x >= n){
            return true;
        }
        for(int[] array : snake){
            if(Arrays.equals(array, new int[]{y,x})){
                return true;
            }
        }
        return false;
    }
}

