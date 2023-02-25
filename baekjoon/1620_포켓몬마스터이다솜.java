package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static Map<String, String> poketNumber = new HashMap<>();
    public static Map<String, String> poketName = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=1; i<=n; i++){
            String s = br.readLine();
            poketNumber.put(Integer.toString(i), s);
            poketName.put(s, Integer.toString(i));
        }
        for(int i=0; i<m; i++){
            String search = br.readLine();
            // 하나이상의 숫자만 -> 키로 검색
            if(search.matches("[0-9]+")){
                System.out.println(poketNumber.get(search));
            }
            // 영문만 -> value로 검색
            else if(search.matches("[a-zA-Z]+")){
                System.out.println(poketName.get(search));
//                for(Map.Entry<String, String> entry : poket.entrySet()){
//                    if(entry.getValue().equals(search)){
//                        System.out.println(entry.getKey());
//                        break;
//                    }
//                }
            }
        }
    }
}

