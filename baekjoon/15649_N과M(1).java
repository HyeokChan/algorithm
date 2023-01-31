package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static int n, m;
    public static boolean[] visit;
    public static int[] source;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        source = new int[n];
        for(int i=0; i<n; i++){
            source[i] = i+1;
        }
        visit = new boolean[n];
        printNums(source, new int[m], visit, m, 0);
    }

    public static void printNums(int[] source, int[] out, boolean[] visit, int r, int depth){
        if(depth == r){
            for(int i=0; i<out.length; i++){
                System.out.print(out[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<source.length; i++){
            if(!visit[i]){
                visit[i] = true;
                out[depth] = source[i];
                printNums(source, out, visit, r, depth+1);
                visit[i] = false;
            }
        }
    }
}


