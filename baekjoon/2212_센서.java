package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static int[] sensors;
    public static int[] distances;
    public static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        sensors = new int[n];
        distances = new int[n-1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        // 센서를 위치 순으로 정렬
        Arrays.sort(sensors);

        // 위치 별 거리 계산
        for(int i=0; i<n-1; i++){
            distances[i] = sensors[i+1] - sensors[i];
        }

        // 거리를 정렬하여 제일 거리가 먼 곳에 탐지기를 설치하도록 계산
        Arrays.sort(distances);
        for(int i=0; i<distances.length-(k-1); i++){
            result += distances[i];
        }
        System.out.println(result);
    }
}


