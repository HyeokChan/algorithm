package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            stack.clear();
            String line = br.readLine();
            if(".".equals(line)){
                break;
            }
            for(Character c : line.toCharArray()){
                if(c == '(' || c == '[' || c == ')' || c == ']' ){
                    if(stack.isEmpty()){
                        stack.push(c);
                    }
                    else if (!stack.isEmpty()) {
                        if(c == ')'){
                            if(stack.peek() == '('){
                                stack.pop();
                            }
                            else {
                                stack.push(c);
                            }
                        }
                        else if(c == ']'){
                            if(stack.peek() == '['){
                                stack.pop();
                            }
                            else {
                                stack.push(c);
                            }
                        }
                        else {
                            stack.push(c);
                        }
                    }
                }
            }
            if(stack.isEmpty()){
                System.out.println("yes");
            }
            else if(!stack.isEmpty()){
                System.out.println("no");
            }
        }
    }
}
