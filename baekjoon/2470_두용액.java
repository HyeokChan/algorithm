package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int min = Integer.MAX_VALUE;
    public static int sRst = 0;
    public static int eRst = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        // 정렬
        Collections.sort(list);
        int sIdx = 0;
        int eIdx = list.size() - 1;
        int tMin = 0;
        // 앞 인덱스, 뒤 인덱스 비교해가면서 하나 씩 이동
        while (true){
            tMin = list.get(sIdx) + list.get(eIdx);
            // 절대값으로 0과 가까운지 비교
            if(Math.abs(tMin) < min){
                min = Math.abs(tMin);
                sRst = list.get(sIdx);
                eRst = list.get(eIdx);
            }
            // 결과값에 따라 앞, 뒤 인덱스 이동
            if(tMin < 0){
                sIdx++;
            }
            else if(tMin > 0){
                eIdx--;
            }
            else if(tMin == 0){
                break;
            }
            if(sIdx == eIdx){
                break;
            }
        }
        System.out.println(sRst+" "+eRst);
    }
}