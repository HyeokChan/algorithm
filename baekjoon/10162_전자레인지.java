package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int totalTime, count;
    public static ArrayList<Integer> timeTypeList = new ArrayList<>(Arrays.asList(300, 60, 10));
    public static int[] resultArray = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalTime = Integer.parseInt(br.readLine());
        for (int i = 0; i < timeTypeList.size(); i++) {
            count = totalTime / timeTypeList.get(i);
            resultArray[i] = count;
            totalTime -= timeTypeList.get(i) * count;
        }
        if(totalTime == 0){
            Arrays.stream(resultArray).forEach(i->{
                System.out.print(i + " ");
            });
        } else {
            System.out.println(-1);
        }
    }
}