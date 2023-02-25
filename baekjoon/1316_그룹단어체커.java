package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String s = br.readLine();
            char[] chars = s.toCharArray();
            if(checkDup(chars)){
                continue;
            }
            result++;
        }
        System.out.println(result);
    }

    public static boolean checkDup(char[] chars){
        int[] asc = new int[500];
        for(int i=1; i<chars.length; i++){
            if(chars[i-1] != chars[i]){
                asc[(int) chars[i-1]] = -1;
            }
            if(asc[(int) chars[i]] == -1){
                return true;
            }
        }
        return false;
    }
}
