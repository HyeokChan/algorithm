package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static String target, boom;
    public static int boomSize = 0;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Character> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        boom = br.readLine();
        boomSize = boom.length();

        for(char c : target.toCharArray()){
            sb.append(c);
            if(sb.length() >= boomSize) {
                if (checkBoom()) {
                    popBoom();
                }
            }
        }
        String result = sb.toString();
        System.out.println("".equals(result) ? "FRULA" : result);
    }

    public static boolean checkBoom(){
        if(sb.substring(sb.length()-boomSize, sb.length()).equals(boom)){
            return true;
        }
        return false;
    }

    public static void popBoom(){
        sb.delete(sb.length() - boomSize, sb.length());
    }
}
