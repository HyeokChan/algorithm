package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int testCases;
    public static int money, count;
    public static ArrayList<Integer> changeTypeList = new ArrayList<>(Arrays.asList(25, 10, 5, 1));
    public static int[] resultChangeArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            resultChangeArray = new int[4];
            money = Integer.parseInt(br.readLine());
            // 거스름돈 종류 리스트 순회
            for (int j = 0; j < changeTypeList.size(); j++) {
                count = money / changeTypeList.get(j);
                resultChangeArray[j] = count;
                money -= changeTypeList.get(j) * count;
                if(money == 0){
                    break;
                }
            }
            Arrays.stream(resultChangeArray).forEach(result->{
                System.out.print(result + " ");
            });
            System.out.println();
        }
    }
}