package com.company;
import java.io.*;
import java.util.*;

public class Main{
    public static int N, M;
    public static int[] cards;
    public static List<Integer> combiList = new ArrayList<>();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cards = new int[N];
        visited = new boolean[N];
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        combination(cards, new int[3], visited, 0, 0, 3);
        //printCombiList();
        Collections.sort(combiList, Collections.reverseOrder());
        for(int sum : combiList){
            if(sum <= M){
                System.out.println(sum);
                break;
            }
        }
    }

    public static void combination(int[] cards, int[] out, boolean[] visited, int start, int depth, int r){
        if(depth == r){
            int sum = Arrays.stream(out).sum();
            combiList.add(sum);
            return;
        }
        for(int i=start; i<cards.length; i++){
            if(!visited[i]){
                out[depth] = cards[i];
                visited[i] = true;
                combination(cards, out, visited, i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }

    public static void printCombiList(){
        for(int temp : combiList){
            System.out.println(temp);
        }
    }
}
