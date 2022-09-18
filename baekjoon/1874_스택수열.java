package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean breakChk = false;
        int currNum = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stack.push(currNum);
        currNum++;
        sb.append("+").append("\n");
        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            if(stack.isEmpty()){
                stack.push(currNum);
                currNum++;
                sb.append("+").append("\n");
            }
            if(temp < stack.peek()){
                breakChk = true;
                break;
            }
            else if(temp == stack.peek()){
                stack.pop();
                sb.append("-").append("\n");
            } else if (temp > stack.peek()) {
                while (temp >= currNum){
                    stack.push(currNum);
                    currNum++;
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            }
        }
        if(breakChk){
            System.out.println("NO");
        }
        else {
            System.out.println(sb);
        }
    }
}
