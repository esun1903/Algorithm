package com.algorithm.a;

import java.io.*;
import java.util.*;

public class Main_5639_이진검색트리 {

	private static StringBuilder sb = new StringBuilder();

	/*
	 * 노드의 왼쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 작다. 
	 * 노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 크다.
	 * 왼쪽, 오른쪽 서브트리도 이진 검색 트리이다.
	 * 
	 * 이 세가지 조건 
	 * 
	 * 
	 * 
	 * 전위순회 : 루트 -> 왼쪽자식 -> 오른쪽자식
	 * 후위순회 : 왼쪽자식 -> 오른쪽자식 -> 루트 
	 *                 
	 */

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BufferWriter
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = null;

		String line = "";

		while ((line = br.readLine()) != null) { // null이 아닐때만 while문 도는거
			int temp = Integer.parseInt(line);
			if (root == null)
				root = new Node(temp);
			else {
				root.insert(temp);
				// insert하기
			}
		} // end of while

		root.postorder(); // postorder하기

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static class Node { // Node라는 거 돌기
		private int data;
		private Node left;
		private Node right;

		public Node(final int data) {
			this.data = data;
		}

		private void insert(final int data) {
			if (this.data > data) { // data보다 작으면
				if (this.left != null) this.left.insert(data); // 왼쪽
				else	this.left = new Node(data); // 생성
			} else {
				if (this.right != null) 	this.right.insert(data); // 오른쪽
				else	this.right = new Node(data); // 생성
			}
		}

		private void postorder() { //
			if (this.left != null)
				this.left.postorder();
			if (this.right != null)
				this.right.postorder();
			sb.append(this.data).append("\n");
		}
	}

}