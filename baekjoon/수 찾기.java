package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(Arrays.binarySearch(A, temp) >= 0){
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
}
