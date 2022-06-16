package com.company;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        int rx = 0; int ry = 0;
        int bx = 0; int by = 0;
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R'){
                    rx = i; ry = j;
                } else if(map[i][j] == 'B'){
                    bx = i; by = j;
                }
            }
        }

        bfs(rx, ry, bx, by, 0);
        if(min > 10){
            System.out.println(-1);
        }
        else {
            System.out.println(min);
        }
    }

    static void bfs(int rx, int ry, int bx, int by, int cnt){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rx, ry, bx, by, cnt});
        visited[rx][ry][bx][by] = true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int pCnt = pos[4];
            if(pCnt >= 10){
                return;
            }
            // 상,하,좌,우 방향
            for(int i=0; i<4; i++){
                int nRx = pos[0];
                int nRy = pos[1];
                int nBx = pos[2];
                int nBy = pos[3];

                // 빨간 구슬 이동
                while(map[nRx+dx[i]][nRy+dy[i]] != '#'){
                    nRx += dx[i];
                    nRy += dy[i];
                    if(map[nRx][nRy] == 'O'){
                        break;
                    }
                }
                // 파란 구슬 이동
                while(map[nBx+dx[i]][nBy+dy[i]] != '#'){
                    nBx += dx[i];
                    nBy += dy[i];
                    if(map[nBx][nBy] == 'O'){
                        break;
                    }
                }
                // 파란공 도착 시 다른 방향 탐색
                if(map[nBx][nBy] == 'O') {
                    continue;
                }
                // 빨간공만 도착 시 종료
                if(map[nRx][nRy] == 'O') {
                    min = Math.min(min, pCnt+1);
                    return;
                }
                // 빨간공, 파란공 같은 위치일 시 위치 조정
                if(nRx == nBx && nRy == nBy){
                    int redMove = Math.abs(nRx - pos[0]) + Math.abs(nRy - pos[1]);
                    int blueMove = Math.abs(nBx - pos[2]) + Math.abs(nBy - pos[3]);
                    // 더 적게 움직인 공이 더 앞에 있는 공
                    if(redMove > blueMove){
                        nRx -= dx[i];
                        nRy -= dy[i];
                    } else {
                        nBx -= dx[i];
                        nBy -= dy[i];
                    }
                }

                if(!visited[nRx][nRy][nBx][nBy]){
                    visited[nRx][nRy][nBx][nBy] = true;
                    queue.add(new int[]{nRx, nRy, nBx, nBy, pCnt+1});
                }
            }
        }
    }

}
