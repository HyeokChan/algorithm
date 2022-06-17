package com.company;
import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] A;
    static int B;
    static int C;
    // int값의 범위를 초과하는 값이 나올 수 있다
    static Long totCnt = 0l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // 총감독관 최소 1명씩
        totCnt += A.length;
        for(int i=0; i<A.length; i++){
            int studentCnt = A[i] - B;
            if(studentCnt <= 0){
                continue;
            }
            if(studentCnt <= C){
                totCnt++;
                continue;
            }
            if(studentCnt % C > 0){
                totCnt += (studentCnt / C) + 1;
            }
            else {
                totCnt += (studentCnt / C);
            }
        }
        System.out.println(totCnt);
        System.out.println(Integer.MAX_VALUE);

    }

}
