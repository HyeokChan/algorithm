package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 루트노드 생성
        int rootN = Integer.parseInt(br.readLine());
        Node rootNode = new Node(rootN);
        // 입력 끝날 때까지
        while (true){
            String s = br.readLine();
            if(s == null || "".equals(s)){
                break;
            }
            int target = Integer.parseInt(s);
            // 노드 추가
            rootNode.addNode(target);
        }
        // 후위 순회
        postVisit(rootNode);
    }
    // 후위 순회
    public static void postVisit(Node node){
        // 왼쪽, 오른쪽으로 탐색한 노드가 없으면 부모로 돌아가기 위한 종료조건
        if(node == null){
            return;
        }
        // 왼쪽 자식노드부터 우선적으로 파고 들어감
        postVisit(node.left);
        // 왼쪽 자식노드 확인 후에 오른쪽 자식노드 확인
        postVisit(node.right);
        // 자신노드값 출력
        System.out.println(node.n);
    }
    // 노드 클래스
    public static class Node{
        int n;
        Node left;
        Node right;
        public Node(int n){
            this.n = n;
        }
        // 자식노드 추가(재귀)
        public void addNode(int target){
            if(target < this.n){
                // 왼쪽 자식노드가 없으면 왼쪽 자식노드로 추가
                if(this.left == null){
                    this.left = new Node(target);
                }
                // 있으면 왼쪽 자식노드로 재검사
                else {
                    this.left.addNode(target);
                }
            }
            else if(this.n < target){
                // 오른쪽 자식노드가 없으면 오른쪽 자식노드로 추가
                if(this.right == null){
                    this.right = new Node(target);
                }
                // 있으면 오른쪽 자식노드로 재검사
                else {
                    this.right.addNode(target);
                }
            }
        }
    }
}


