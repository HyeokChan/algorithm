package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int end, current, target, up, down;
    public static int[] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        end = Integer.parseInt(st.nextToken());
        current = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());
        visit = new int[end+1];
        visit[current] = 1;
        int result = takeElb(current);
        if(result == -1){
            System.out.println("use the stairs");
        }
        else {
            System.out.println(result);
        }
    }

    public static int takeElb(int floor){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(floor);
        int[] dfloor = new int[]{up, down*-1};
        while (!queue.isEmpty()){
            int curFloor = queue.poll();
            if(curFloor == target){
                return visit[curFloor]-1;
            }
            for(int i=0; i<2; i++){
                int nfloor = curFloor+dfloor[i];
                if(nfloor < 1 || nfloor > end || nfloor == curFloor || visit[nfloor]!=0){
                    continue;
                }
                queue.add(nfloor);
                visit[nfloor] = visit[curFloor]+1;
            }
        }
        return -1;
    }
}
