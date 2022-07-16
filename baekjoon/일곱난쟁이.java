package com.company;
import java.util.*;
import java.io.*;
public class Main {
    static int[] person;
    static int[] out;
    static boolean[] visited;
    static boolean breakPoint = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        person = new int[9];
        out = new int[7];
        visited = new boolean[9];
        int r = 7;
        for(int i=0; i<9; i++){
            person[i] = Integer.parseInt(br.readLine());
        }
        combination(person, out, visited, 0, 0, r);

    }
    public static void combination(int[] person, int[] out, boolean[] visited, int depth, int start, int r){
        if(depth == r){
            int sum = Arrays.stream(out).sum();
            if(sum == 100){
                Arrays.sort(out);
                Arrays.stream(out).forEach(System.out::println);
                breakPoint = true;
            }
            return;
        }
        for(int i=start; i<person.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = person[i];
                combination(person, out, visited, depth+1, i+1, r);
                if(breakPoint){
                    break;
                }
                visited[i] = false;
            }
        }
        if(breakPoint){
            return;
        }
    }
}
