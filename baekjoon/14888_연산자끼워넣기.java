package com.company;
import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static ArrayList<Integer> nums = new ArrayList<>();
    public static int[] calcCnt = new int[4];
    public static char[] calcs;
    public static boolean[] visited;
    public static ArrayList<char[]> permList = new ArrayList<>();
    public static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 입력값 저장
        N = Integer.parseInt(br.readLine());
        calcs = new char[N - 1];
        visited = new boolean[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calcCnt[i] = Integer.parseInt(st.nextToken());
        }
        // calc 저장
        saveCalc();
        //printCalc();

        // calc 순열만들기
        perm(calcs, new char[calcs.length], visited, 0, calcs.length);
        //printPermList();

        // 계산하기
        ArrayList<Integer> tempNums = new ArrayList<>();
        for (int i = 0; i < permList.size(); i++) {
            tempNums = (ArrayList<Integer>) nums.clone();
            // + + - x /
            int calcIdx = 0;
            while (tempNums.size() != 1){
                int x = tempNums.get(0);
                int y = tempNums.get(1);
                int temp = 0;
                if(permList.get(i)[calcIdx] == '+'){
                    temp = x + y;
                }
                if(permList.get(i)[calcIdx] == '-'){
                    temp = x - y;
                }
                if(permList.get(i)[calcIdx] == 'x'){
                    temp = x * y;
                }
                if(permList.get(i)[calcIdx] == '/'){
                    temp = x / y;
                }
                tempNums.set(0, temp);
                tempNums.remove(1);
                calcIdx++;
            }
            result.add(tempNums.get(0));
        }
        System.out.println(result.stream().mapToInt(i->i).max().orElse(0));
        System.out.println(result.stream().mapToInt(i->i).min().orElse(0));
    }

    public static void printPermList(){
        for(char[] calcPerms : permList){
            for(char calcs : calcPerms){
                System.out.print(calcs + " ");
            }
            System.out.println();
        }
    }

    // 순열만들기
    public static void perm(char[] source, char[] out, boolean[] visited, int depth, int r){
        if(depth == r){
            permList.add(out.clone());
            return;
        }
        for(int i=0; i<source.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = source[i];
                perm(source, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    public static void printCalc(){
        for(char calc : calcs){
            System.out.println(calc);
        }
    }

    public static void saveCalc(){
        int calcIdx = 0;
        if(calcCnt[0] > 0){
            for (int i = 0; i < calcCnt[0]; i++) {
                calcs[calcIdx] = '+';
                calcIdx++;
            }
        }
        if(calcCnt[1] > 0){
            for (int i = 0; i < calcCnt[1]; i++) {
                calcs[calcIdx] = '-';
                calcIdx++;
            }
        }
        if(calcCnt[2] > 0){
            for (int i = 0; i < calcCnt[2]; i++) {
                calcs[calcIdx] = 'x';
                calcIdx++;
            }
        }
        if(calcCnt[3] > 0){
            for (int i = 0; i < calcCnt[3]; i++) {
                calcs[calcIdx] = '/';
                calcIdx++;
            }
        }
    }
}
