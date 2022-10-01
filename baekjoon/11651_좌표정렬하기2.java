package com.company;
import java.util.*;
import java.io.*;

public class Main{
    public static int N;
    public static int[][] point;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        point = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point[i] = new int[]{y, x};
        }
        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]){
                    return 1;
                }
                else if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < point.length; i++) {
            System.out.println(point[i][1] + " " + point[i][0]);
        }
    }
}
