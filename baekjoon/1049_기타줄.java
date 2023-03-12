package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int price = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int setNum = Integer.MAX_VALUE;
        int num = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            setNum = Math.min(setNum, Integer.parseInt(st.nextToken()));
            num = Math.min(num, Integer.parseInt(st.nextToken()));
            price = calcPrice(setNum, num);
        }
        System.out.println(price);
    }

    public static int calcPrice(int setNum, int num){
        int tResult = Integer.MAX_VALUE;
        // 세트로만 계산
        int sm = n/6;
        int d = n%6;
        if(d != 0){
            sm += 1;
        }
        tResult = Math.min(tResult, sm*setNum);

        // 조합으로 계산
        sm = n/6;
        tResult = Math.min(tResult, sm*setNum+d*num);

        // 단품으로만 계산
        tResult = Math.min(tResult, n*num);

        return tResult;
    }
}


