package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int t, n;
    public static char[] pArray;
    public static ArrayList<String> list = new ArrayList<>();
    public static Deque<String> deque = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        // 테스트 케이스
        for(int i=0; i<t; i++){
            pArray = br.readLine().toCharArray();
            n = Integer.parseInt(br.readLine());
            String info = br.readLine();
            info = info.substring(1, info.length()-1);
            if(!"".equals(info)){
                deque = new LinkedList<>(Arrays.asList(info.split(",")));
            }
            process();
        }
    }

    public static void process(){
        sb = new StringBuilder();
        boolean front = true;
        for(char p : pArray){
            if(p == 'R'){
                front = !front;
            }
            else if(p == 'D'){
                if(deque.isEmpty()){
                    System.out.println("error");
                    return;
                }
                if(front){
                    deque.removeFirst();
                }
                else {
                    deque.removeLast();
                }
            }
        }
        sb.append("[");
        if(!deque.isEmpty()){
            if(front){
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            }
            else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}
