package com.company;
import java.util.*;
import java.io.*;

public class Main {
    static int[][] intArray;
    static String[][] stringArray;
    static List<Member> members;
    // Comparator
    public static void main(String[] args) throws IOException {
        // int 2차원 배열 정렬 (첫번째 값부터 내림차순)
        intArray = new int[][]{{1,1,1},{1,2,3},{2,2,1},{2,2,3},{4,4,4}};
        intArraySort();
        printIntArray();

        // String 2차원 배열 정렬 (두번째 * 세번째 값 내림차순, 같을 시 첫번째 값 오름차순(대소문자구분X))
        stringArray = new String[][]{{"apple", "15", "100"},{"banana", "5", "1000"},{"bana", "1", "5000"}, {"z","100","15"}};
        stringArraySort();
        printStringArray();

        // 객체 정렬 (나이-경력이 작은순으로, 같다면 이름순으로)
        members = new ArrayList<>();
        members.add(new Member("kano", 40, 10));
        members.add(new Member("kano", 26, 2));
        members.add(new Member("chan", 27, 5));
        objectArraySort();
        printObjectArray();

    }

    // int 2차원 배열 정렬 (첫번째 값부터 내림차순)
    public static void intArraySort(){
        Arrays.sort(intArray, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    if(o1[1] == o2[1]){
                        if(o1[2] >= o1[2]){
                            return -1;
                        }
                        else {
                            return 1;
                        }
                    }
                    else if(o1[1] > o2[1]){
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
                else if(o1[0] > o2[0]){
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });
    }

    // String 2차원 배열 정렬 (두번째 * 세번째 값 내림차순, 같을 시 첫번째 값 오름차순(대소문자구분X))
    public static void stringArraySort(){
        Arrays.sort(stringArray, new Comparator<String[]>(){
            public int compare(String[] o1, String[] o2){
                int o1Tot = Integer.parseInt(o1[1]) * Integer.parseInt(o1[2]);
                int o2Tot = Integer.parseInt(o2[1]) * Integer.parseInt(o2[2]);
                if(o1Tot == o2Tot){
                    if(o1[0].compareToIgnoreCase(o2[0]) >= 0){
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
                else if(o1Tot > o2Tot){
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });
    }

    // 객체 정렬 (나이-경력이 작은순으로, 같다면 이름순으로)
    public static void objectArraySort(){
        Collections.sort(members, new Comparator<Member>(){
            public int compare(Member member1, Member member2){
                if(member1.age-member1.ann == member2.age-member2.ann){
                    if(member1.name.compareToIgnoreCase(member2.name) >= 0){
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
                else if(member1.age-member1.ann < member2.age-member2.ann){
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });
    }
    public static class Member{
        String name;
        int age;
        int ann;

        public Member(String name, int age, int ann) {
            this.name = name;
            this.age = age;
            this.ann = ann;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAnn() {
            return ann;
        }

        public void setAnn(int ann) {
            this.ann = ann;
        }
    }

    // 정렬 결과 출력
    public static void printIntArray(){
        for(int[] temp : intArray){
            for(int info : temp){
                System.out.print(info + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printStringArray(){
        for(String[] temp : stringArray){
            for(String info : temp){
                System.out.print(info + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printObjectArray(){
        for(Member member : members){
            System.out.println(member.getName() + " " + member.getAge() + " " + member.getAnn());
        }
        System.out.println();
    }
}
