package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static Long a, b;
    public static int result = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        calcNum(a, 0);
        System.out.println(result);
    }

    public static void calcNum(long num, int depth){
        if(num > b){
            return;
        }
        if(num == b){
            if(result == -1){
                result = depth+1;
            }
            else {
                result = Math.min(result, depth+1);
            }
            return;
        }
        calcNum(num*2, depth+1);
        calcNum(Long.parseLong(num+"1"), depth+1);
    }
}


