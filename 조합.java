package com.company;


import java.io.*;
import java.util.stream.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int r = 4;
        int[] rate = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        boolean[] visited = new boolean[rate.length];
        // 백트래킹
        comb1(rate, visited, 0, r);
        // 재귀
        comb2(rate, visited, 0, r);
        for(int i=0; i<lists.size(); i++){
            for(int j=0; j<lists.get(0).size(); j++){
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    // nCr = n-1Cr-1 + n-1Cr
    // 백트래킹
    public static void comb1(int[] rate, boolean[] visited, int start, int r){
        // 조합구하기 종료
        if(r == 0){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<rate.length; i++){
                if(visited[i] == true){
                    list.add(rate[i]);
                }
            }
            lists.add(list);
            return;
        } else {
            for(int i=start; i<rate.length; i++){
                visited[i] = true;
                comb1(rate, visited, i+1, r-1);
                visited[i] = false;
            }
        }
    }

    // 조합
    public static void comb2(int[] rate, boolean[] visited, int depth, int r){
        if(r == 0){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<rate.length; i++){
                if(visited[i] == true){
                    list.add(rate[i]);
                }
            }
            lists.add(list);
            return;
        }
        if(depth == rate.length){
            return;
        } else {
            visited[depth] = true;
            comb2(rate, visited, depth+1, r-1);
            visited[depth] = false;
            comb2(rate, visited, depth+1, r);
        }
    }





}
