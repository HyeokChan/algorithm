package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static ArrayList<String> hearList = new ArrayList<>();
    public static ArrayList<String> results = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            hearList.add(br.readLine());
        }
        Collections.sort(hearList);
        for (int i = 0; i < M; i++) {
            String seeTarget = br.readLine();
            if(binarySearch(seeTarget)){
                results.add(seeTarget);
            }
        }
        Collections.sort(results);
        System.out.println(results.size());
        for(String result : results){
            System.out.println(result);
        }
    }
    public static boolean binarySearch(String target) {
        int start = 0;
        int end = hearList.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(target.compareTo(hearList.get(mid)) < 0){
                end = mid - 1;
            }
            else if(target.compareTo(hearList.get(mid)) > 0){
                start = mid + 1;
            }
            else if(target.compareTo(hearList.get(mid)) == 0){
                return true;
            }
        }
        return false;
    }
}
