package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991_트리순회 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char node, left = '.', right = '.';
		Tree t = new Tree();
		for (int i = 1; i <= N; i++) { // 1부터 N까지
			String str = br.readLine();
			node = str.charAt(0);
			if (str.charAt(2) != '.')
				left = str.charAt(2);
			else
				left = '.';
			if (str.charAt(4) != '.')
				right = str.charAt(4);
			else
				right = '.';
			t.createNode(left, node, right);
		} // end of for
		t.preOrder(t.root);
		System.out.println();
		t.inOrder(t.root);
		System.out.println();
		t.postOrder(t.root);
	}

	public static class Node {
		char data;
		Node left;
		Node right;

		public Node(char data) {
			this.data = data;
		}

	}

	public static class Tree {
		public Node root;

		public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}

		public void preOrder(Node root) {
			if (root != null) {
				System.out.print(root.data);
				if (root.left != null)
					preOrder(root.left);
				if (root.right != null)
					preOrder(root.right);
			}
		}

		public void inOrder(Node root) {  // 중위 (왼쪽자식 -> 오른쪽자식 -> 루트 ) 
			if (root != null) {
				if (root.left != null)
					inOrder(root.left);
				System.out.print(root.data);
				if (root.right != null)
					inOrder(root.right);
			}
		}

		public void postOrder(Node root) {
			if (root != null) {
				if (root.left != null)
					postOrder(root.left);
				System.out.print(root.data);
				if (root.right != null)
					postOrder(root.right);
			}
		}

		public void createNode(char left, char data, char right) {
			root = new Node(data);
			root.left = new Node(left);
			root.right = new Node(right);
		} // end of createNode

	}

}

/**
 * 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위
 * 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오
 * 
 * 첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽
 * 자식 노드가 주어진다. 노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는
 * .으로 표현된다.
 */