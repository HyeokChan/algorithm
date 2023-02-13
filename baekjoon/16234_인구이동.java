package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n, l, r;
    public static int[][] board;
    public static ArrayList<Node> list = new ArrayList<>();
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 초기화
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 이동
        int result = movePop();
        System.out.println(result);
    }

    public static int movePop(){
        int result = 0;
        // 연합이 없을 때까지 반복
        while (true){
            boolean isMove = false;
            visited = new boolean[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j]){
                        int sum = bfs(i,j);
                        if(list.size() > 1) {
                            // 한번이라도 연합이 됐으면 재시도
                            isMove = true;
                            // 평균값 처리
                            setAvg(sum);
                        }
                    }
                }
            }
            if(!isMove){
                return result;
            }
            result++;
        }
    }

    public static void setAvg(int sum){
        int avg = sum / list.size();
        for(Node node : list){
            board[node.y][node.x] = avg;
        }
    }

    public static int bfs(int y, int x){
        int dy[] = {1,0,-1,0};
        int dx[] = {0,1,0,-1};
        Queue<Node> queue = new LinkedList<>();
        list = new ArrayList<>();

        queue.add(new Node(y, x));
        list.add(new Node(y, x));
        visited[y][x] = true;
        int sum = board[y][x];

        while (!queue.isEmpty()){
            Node curr = queue.poll();
            for(int i=0; i<4; i++){
                int ny = curr.y+dy[i];
                int nx = curr.x+dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx]){
                    if(l <= Math.abs(board[curr.y][curr.x]-board[ny][nx]) && Math.abs(board[curr.y][curr.x]-board[ny][nx]) <= r){
                        queue.add(new Node(ny,nx));
                        list.add(new Node(ny,nx));
                        sum += board[ny][nx];
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return sum;
    }

    public static class Node {
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
