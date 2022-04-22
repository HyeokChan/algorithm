package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String dartResult = "1D2S#10S";
        int answer = solution(dartResult);
        System.out.println("answer = " + answer);
    }

    public static int solution(String dartResult) {
        int answer = 0;
        char[] darts = dartResult.toCharArray();
        int[] score = new int[3];
        String dartsTemp = "";
        int scoreIdx = 0;
        int powValue = 0;
        for (int i = 0; i < darts.length; i++) {
            if (darts[i] != '*' && darts[i] != '#') {
                if (darts[i] != 'S' && darts[i] != 'D' && darts[i] != 'T') {
                    dartsTemp += darts[i];
                } else {
                    if (darts[i] == 'S') {
                        powValue = 1;
                    } else if (darts[i] == 'D') {
                        powValue = 2;
                    } else if (darts[i] == 'T') {
                        powValue = 3;
                    }
                    score[scoreIdx] = (int)Math.pow(Integer.parseInt(dartsTemp), powValue);
                    scoreIdx++;
                    dartsTemp = "";
                }
            } else {
                if (darts[i] == '#') {
                    score[scoreIdx-1] *= -1;
                } else if(darts[i] == '*'){
                    score[scoreIdx-1] *= 2;
                    if (scoreIdx-2 >= 0) {
                        score[scoreIdx-2] *= 2;
                    }
                }
                dartsTemp = "";
            }
        }
        answer = Arrays.stream(score).sum();
        return answer;
    }
}
