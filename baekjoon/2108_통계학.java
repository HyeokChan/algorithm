package com.company;
import java.util.*;
import java.io.*;

public class Main{
    public static int N;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            list.add(x);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Collections.sort(list);
        float avgTemp = list.stream().mapToInt(i -> i).sum() / (float) list.size();
        int avg = Math.round(avgTemp);
        int mid = list.get(list.size() / 2);
        int ran = list.get(list.size() - 1) - list.get(0);
        int bin = 0;
        Object[] keySet = map.keySet().toArray();
        // 빈도수로 내림차순 정렬
        Arrays.sort(keySet, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                return map.get((Integer) o2) - map.get((Integer) o1);
            }
        });
        int maxCnt = map.get(keySet[0]);
        ArrayList<Object> binList = new ArrayList<>();
        for (int i = 0; i < keySet.length; i++) {
            int value = map.get(keySet[i]);
            // 최고빈도수와 같은 모든 키값 저장
            if(value == maxCnt){
                binList.add(keySet[i]);
            }
        }
        if(binList.size() >= 2){
            // 두번째로 작은값 찾기 위해서 내림차순 정렬
            Collections.sort(binList, new Comparator<Object>() {
                @Override
                public int compare(Object o1, Object o2) {
                    return (Integer) o1 - (Integer) o2;
                }
            });
            bin = (Integer)binList.get(1);
        }
        else {
            // 값이 하나면 그 값 저장
            bin = (Integer)binList.get(0);
        }
        System.out.println(avg);
        System.out.println(mid);
        System.out.println(bin);
        System.out.println(ran);
    }
}
