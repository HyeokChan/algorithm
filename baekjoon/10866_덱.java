package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String process = br.readLine();
            String pcSeCd = process.split(" ")[0];
            if("push_front".equals(pcSeCd)){
                list.add(0, process.split(" ")[1]);
            } else if("push_back".equals(pcSeCd)){
                list.add(process.split(" ")[1]);
            } else if ("pop_front".equals(pcSeCd)) {
                if (list.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(list.get(0));
                list.remove(0);
            } else if ("pop_back".equals(pcSeCd)) {
                if (list.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(list.get(list.size()-1));
                list.remove(list.size()-1);
            } else if ("size".equals(pcSeCd)) {
                System.out.println(list.size());
            } else if ("empty".equals(pcSeCd)) {
                if (list.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if ("front".equals(pcSeCd)) {
                if (list.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(list.get(0));
            } else if ("back".equals(pcSeCd)) {
                if (list.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(list.get(list.size()-1));
            }
        }
    }
}
