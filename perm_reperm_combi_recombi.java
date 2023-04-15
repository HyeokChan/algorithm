package com.company;
import java.io.*;
import java.util.*;

public class Main {
    static int[] source;
    static ArrayList<int[]> result;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        source = new int[]{1,2,3,4};
        result = new ArrayList<>();
        // 뽑는 수
        int r = 2;

        switch (num) {
            case 1 :
                // 순열
                permutation(source, new int[r], new boolean[source.length], 0, r);
                break;
            case 2 :
                // 중복순열
                repermutation(source, new int[r], 0, r);
                break;
            case 3 :
                // 조합
                combination(source, new int[r], new boolean[source.length], 0, 0, r);
                break;
            case 4 :
                // 중복조합
                recombination(source, new int[r], 0, 0, r);
                break;
        }

    }
    // 순열
    public static void permutation(int[] source, int[] out, boolean[] visited, int depth, int r){
        if(depth == r){
            result.add(out.clone());
            for(int num : out) System.out.print(num + " ");
            System.out.println();
            return;
        }
        for(int i=0; i<source.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = source[i];
                permutation(source, out, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }
    // 중복 순열
    public static void repermutation(int[] source, int[] out, int depth, int r){
        if(depth == r){
            result.add(out.clone());
            for(int num : out) System.out.print(num + " ");
            System.out.println();
            return;
        }
        for(int i=0; i<source.length; i++){
            out[depth] = source[i];
            repermutation(source, out, depth+1, r);
        }
    }
    // 조합
    public static void combination(int[] source, int[] out, boolean[] visited, int start, int depth, int r){
        if(depth == r){
            result.add(out.clone());
            for(int num : out) System.out.print(num + " ");
            System.out.println();
            return;
        }
        for(int i=start; i<source.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = source[i];
                combination(source, out, visited, i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }
    // 중복조합
    public static void recombination(int[] source, int[] out, int start, int depth, int r){
        if(depth == r){
            result.add(out.clone());
            for(int num : out) System.out.print(num + " ");
            System.out.println();
            return;
        }
        for(int i=start; i<source.length; i++){
            out[depth] = source[i];
            recombination(source, out, i, depth+1, r);
        }
    }
}
