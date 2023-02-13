package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static int n, pCnt;
    public static int[] switchs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        switchs = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            switchs[i] = Integer.parseInt(st.nextToken());
        }
        pCnt = Integer.parseInt(br.readLine());
        for(int i=0; i<pCnt; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            // 남학생
            if(sex == 1){
                setManSwitch(num);
            }
            // 여학생
            else if(sex == 2){
                setWomanSwitch(num);
            }
        }
        for(int i=1; i<switchs.length; i++){
            System.out.print(switchs[i]+" ");
            if(i%20==0){
                System.out.println();
            }
        }
    }
    // 남학생
    public static void setManSwitch(int num){
        for(int i=num; i<switchs.length; i+=num){
            switchs[i] = (switchs[i]+1)%2;
        }
    }
    // 여학생
    public static void setWomanSwitch(int num){
        // 받은 번호 위치
        switchs[num] = (switchs[num]+1)%2;
        int dx = 1;
        // 대칭 비교
        while (true){
            int leftIdx = num - dx;
            int rightIdx = num + dx;
            if(leftIdx < 1 || rightIdx >= switchs.length){
                break;
            }
            if(switchs[leftIdx] != switchs[rightIdx]){
                break;
            }
            switchs[leftIdx] = (switchs[leftIdx]+1)%2;
            switchs[rightIdx] = (switchs[rightIdx]+1)%2;
            dx++;
        }
    }
}
