package com.company;
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            // 초기화
            st = new StringTokenizer(br.readLine());
            int totCnt = Integer.parseInt(st.nextToken());
            // 내 프린트 인덱스
            int myPrintIdx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            queue.clear();
            int rst = 0;
            for (int j = 0; j < totCnt; j++) {
                int temp = Integer.parseInt(st.nextToken());
                queue.add(temp);
            }

            // 최우선순위 찾기
            int maxPrior = getMaxPrior(queue);
            while (true) {
                // 제일 앞 자료가 최우선순위
                if(queue.peek() == maxPrior){
                    // 제일 앞이 내 프린트
                    if(myPrintIdx == 0){
                        rst++;
                        break;
                    }
                    // 최우선순위가 제일 앞인데 내 프린트가 아니다
                    else {
                        queue.poll();
                        rst++;
                        // 최우선순위 갱신
                        maxPrior = getMaxPrior(queue);
                        // 내 위치 갱신
                        myPrintIdx--;
                    }
                }
                // 제일 앞 자료가 최우선순위가 아니다.
                else {
                    queue.add(queue.poll());
                    // 제일 앞이 내 프린트
                    if(myPrintIdx == 0){
                        myPrintIdx = queue.size()-1;
                    }
                    else {
                        myPrintIdx--;
                    }
                }
            }
            System.out.println(rst);
        }
    }
    public static int getMaxPrior(Queue<Integer> queue){
        int max = queue.stream().mapToInt(i -> i).max().orElse(-1);
        return max;
    }
}
