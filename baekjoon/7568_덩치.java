package com.company;
import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static List<int[]> list = new ArrayList<>();
    public static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        result = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        for(int i=0; i<N; i++){
            int cnt = 0;
            for(int j=0; j<N; j++){
                if(i==j){
                    continue;
                }
                if(list.get(i)[0] < list.get(j)[0] && list.get(i)[1] < list.get(j)[1]){
                    cnt++;
                }
            }
            result[i] = cnt+1;
        }
        Arrays.stream(result).forEach(i -> {
            System.out.print(i + " ");
        });
    }
}
