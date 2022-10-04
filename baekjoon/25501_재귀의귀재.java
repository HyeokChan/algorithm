package com.company;
import java.io.*;

public class Main{
    public static int N;
    public static int cnt;
    public static int[] result = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            cnt = 0;
            String s = br.readLine();
            result = isPalindrome(s);
            System.out.println(result[0] + " " + result[1]);
        }
    }
    public static int[] isPalindrome(String s){
        int[] temp = new int[2];
        int sfSeCd = recursion(s, 0, s.length()-1);
        temp[0] = sfSeCd;
        temp[1] = cnt;
        return temp;
    }
    public static int recursion(String s, int left, int right){
        cnt++;
        if(left >= right){
            return 1;
        }
        else if(s.toCharArray()[left] != s.toCharArray()[right]){
            return 0;
        }
        else {
            return recursion(s, left + 1, right - 1);
        }
    }
}
