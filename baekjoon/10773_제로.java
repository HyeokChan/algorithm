package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<K; i++){
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                stack.pop();
            }
            else {
                stack.push(temp);
            }
        }
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
