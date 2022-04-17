package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] orders = new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = new int[]{2,3,5};
        String[] answer = solution(orders, course);
        Arrays.stream(answer).forEach(System.out::println);
    }

    static List<String> combination = new ArrayList<>();
    public static String[] solution(String[] orders, int[] course) {
        combination = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            String[] chars = orders[i].split("");
            Arrays.sort(chars);
            for (int j = 0; j < chars.length - 1; j++) {
                for (int k = 0; k < course.length; k++) {
                    dfs(chars, j, 1, course[k], chars[j]);
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for(String menu : combination) {
            map.put(menu, map.getOrDefault(menu, 0)+1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return map.get(o2)-map.get(o1);
            }
        });

        List<String> res = new ArrayList<>();
        for(int i=0; i< course.length; i++) {
            int max =0;
            for(String courseMenu : list) {
                if(map.get(courseMenu)>1 && courseMenu.length() == course[i]) {
                    if(map.get(courseMenu) >= max) {
                        res.add(courseMenu);
                        max = map.get(courseMenu);
                    }
                }
            }
        }

        Collections.sort(res);

        String[] answer = new String[res.size()];
        res.toArray(answer);

        return answer;
    }

    private static void dfs(String[] chars, int idx, int len, int courseValue, String str) {
        if (len == courseValue) {
            combination.add(str);
        }
        for(int i= idx+1; i<chars.length; i++) {
            dfs(chars, i, len+1, courseValue, str+chars[i]);
        }

    }


}
