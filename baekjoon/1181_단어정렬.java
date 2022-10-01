package com.company;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main{
    public static int N;
    public static List<String> words = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String x = br.readLine();
            words.add(x);
        }
        words = words.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
        Collections.sort(words, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(o1.length() > o2.length()){
                    return 1;
                }
                else if(o1.length() == o2.length()){
                    if(o1.compareTo(o2) > 0){
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
                else {
                    return -1;
                }
            }
        });
        for(String word : words){
            System.out.println(word);
        }
    }
}
