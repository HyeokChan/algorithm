package com.company;
import java.util.*;

/**
 * 알고리즘 풀이 하면서 찾아본 것 정리
 * 간단한 코드
 */
public class Main {
    public static void main(String[] args) {
        // int 배열의 특정 숫자 포함여부
        boolean result1 = findIntArrayContainsYn();
        System.out.println("result1 = " + result1);
    }

    /**
     * int 배열의 특정 숫자 포함여부
     * @return 포함 시 true, 미포함 시 false
     */
    private static boolean findIntArrayContainsYn() {
        int[] intArray = {1, 2, 3, 4, 5};
        int key = 3;
        // 1번 stream
        if(Arrays.stream(intArray).anyMatch(num->num==key)){
            return true;
        }
        // 2번 List 변환
        if(Arrays.asList(intArray).contains(key)){
            return true;
        }
        // 3번 binary search (정렬 필요)
        Arrays.sort(intArray);
        if(Arrays.binarySearch(intArray, key) >= 0){
            return true;
        }
        return false;
    }
}
