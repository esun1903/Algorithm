import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_���谨�� {

	public static void main(String[] args) throws IOException {
		/*
		 * �� N���� �������� �ְ� , ������ �����帶�� �����ڵ��� �ִ�. i�� �����忡 �ִ� �������� ���� Ai���̴� . �������� �Ѱ�������
		 * �ΰ��������� �� ������ �ִ�,. �� �������� �� �����忡�� ������ �� �ִ� �������� ���� B���̰� �ΰ������� �� �����忡�� �������� ��
		 * �ִ� �������� �� C���̴�. ������ �����忡 �Ѱ������� ���� 1�� �־���ϰ�, �ΰ������� ���� �� �־ �ȴ�. �� �����帶�� ���û�����
		 * ��� �����ؾ� �Ѵ�. �̶�, �ʿ��� ������ ���� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�
		 * 
		 * �Է� ) ù° �ٿ� ���������� ���� N�� �־�����, ��° �ٿ��� �� �����忡 �ִ� �������� �� Aj�� �־�����. ��° �ٿ��� B�� C��
		 * �־�����.
		 * 
		 * ��� ) �� �����帶�� ���û��� ��� �����ϱ� ���� �ʿ��� �������� �ּ� ���� ����Ѵ�.
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // �������� ��
		long result = 0;

		int[] A = new int[N]; // i�� �����忡 �ִ� �������� ��
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		} // end of for

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); // �Ѱ������� �� �����忡�� ������ �� �ִ� �������� ���� B��
		int C = Integer.parseInt(st.nextToken()); // �ΰ������� �� �����忡�� ������ �� �ִ� �������� ��

		// �Ѱ������� �� �����忡 �� �� ���� �� �ִ�.
		// �ΰ������� ���� �� �־ �ȴ�.
		for (int i = 0; i < N; i++) {
			// 1) �Ѱ����� ���� -> �������� �߰� ������ �α�
			int middle = A[i] - B;  
			result++;
			if (middle > 0) {
				if (middle % C == 0)
					result += middle / C;
				else
					result += middle / C + 1;
			}
		} // end of for

		System.out.println(result); // �� �����帶�� ���û��� ��� �����ϱ� ���� �ʿ��� �������� �ּ� ���� ����Ѵ�.

	} // end of main

} // end of class
