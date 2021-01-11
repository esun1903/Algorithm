package day0906;

public class cording_1번 {

	public static int xL;
	public static int xR;

	// 키패드 누르기
	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		System.out.println(solution(numbers, "right"));

	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";
		int left = 10; // 초기화해줌
		int right = 12;
		for (int i = 0; i < numbers.length; i++) {
			// 1) 1,4,7의 경우
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				left = numbers[i];
				answer += "L";
			}
			// 2) 3,6,9의 경우
			else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				right = numbers[i];
				answer += "R";
			}
			// 3) 2,5,8,0 일때
			else if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {
				// 3 - 1) 둘중 같은 줄에 있는 경우
				if (Math.abs(numbers[i] - left) == 1 || Math.abs(numbers[i] - right) == 1
						|| (numbers[i] == 0 && left == 10) || (numbers[i] == 0 && right == 12)
						|| ((numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0)
								&& ((left == 2 || left == 5 || left == 8 || left == 0)
										|| (right == 2 || right == 5 || right == 8 || right == 0)))) {
					// 3 - 1 -1) 둘다 같은 줄인데 (numbers[i] - left = 1이면 성립 안됨)
					if ((Math.abs(numbers[i] - left) == 1 && Math.abs(numbers[i] - right) == 1
							&& !(numbers[i] == 0 && left == 1))
							|| ((numbers[i] == 0 && left == 10) && (numbers[i] == 0 && right == 12))) {

						if (hand == "right") {
							right = numbers[i];
							answer += "R";
						} else {
							left = numbers[i];
							answer += "L";
						}
					} else if (Math.abs(numbers[i] - left) == 1 || (numbers[i] == 0 && left == 10)) {
						left = numbers[i];
						answer += "L";
					} else if (Math.abs(numbers[i] - right) == 1 || (numbers[i] == 0 && right == 12)) {
						right = numbers[i];
						answer += "R";
					}
				} // end of if

				// 3 - 2) 둘다 같은 줄에 없는 경우
				else {
					if (left == 1) {
						if (Math.abs(numbers[i] - left) == 4)
							xL = 2;
						else if (Math.abs(numbers[i] - left) == 7)
							xL = 3;
						else
							xL = 4;
					} else if (left == 4) {
						if (Math.abs(numbers[i] - left) == 2)
							xL = 2;
						else if (Math.abs(numbers[i] - left) == 4)
							xL = 2;
						else
							xL = 3;
					} else if (left == 7) {
						if (Math.abs(numbers[i] - left) == 5)
							xL = 3;
						else if (Math.abs(numbers[i] - left) == 2)
							xL = 2;
						else
							xL = 2;
					} else if (left == 10) {
						if (Math.abs(numbers[i] - left) == 8)
							xL = 4;
						else if (Math.abs(numbers[i] - left) == 5)
							xL = 3;
						else if (Math.abs(numbers[i] - left) == 2)
							xL = 2;
					} else if (left == 2) {
						if (Math.abs(numbers[i] - left) == 3)
							xL = 1;
						else if (Math.abs(numbers[i] - left) == 6)
							xL = 2;
						else if (Math.abs(numbers[i] - left) == 2)
							xL = 3;
					} else if (left == 5) {
						if (Math.abs(numbers[i] - left) == 3)
							xL = 1;
						else if (Math.abs(numbers[i] - left) == 3)
							xL = 1;
						else if (Math.abs(numbers[i] - left) == 5)
							xL = 2;
					} else if (left == 8) {
						if (Math.abs(numbers[i] - left) == 6)
							xL = 2;
						else if (Math.abs(numbers[i] - left) == 3)
							xL = 1;
						else if (Math.abs(numbers[i] - left) == 8)
							xL = 1;
					} else if (left == 0) {
						if (Math.abs(numbers[i] - left) == 2)
							xL = 3;
						else if (Math.abs(numbers[i] - left) == 5)
							xL = 2;
						else if (Math.abs(numbers[i] - left) == 8)
							xL = 1;
					}
					// ===============================
					if (right == 3) {
						if (Math.abs(numbers[i] - right) == 2)
							xR = 2;
						else if (Math.abs(numbers[i] - right) == 5)
							xR = 3;
						else
							xR = 3;
					} else if (right == 6) {
						if (Math.abs(numbers[i] - right) == 4)
							xR = 2;
						else if (Math.abs(numbers[i] - right) == 2)
							xR = 2;
						else
							xR = 3;
					} else if (right == 9) {
						if (Math.abs(numbers[i] - right) == 7)
							xR = 3;
						else if (Math.abs(numbers[i] - right) == 4)
							xR = 2;
						else
							xR = 2;
					} else if (right == 12) {
						if (Math.abs(numbers[i] - right) == 9)
							xR = 4;
						else if (Math.abs(numbers[i] - right) == 2)
							xR = 3;
						else
							xR = 2;
					}

					else if (right == 2) {
						if (Math.abs(numbers[i] - right) == 3)
							xR = 1;
						else if (Math.abs(numbers[i] - right) == 6)
							xR = 2;
						else if (Math.abs(numbers[i] - right) == 2)
							xR = 3;
					} else if (right == 5) {
						if (Math.abs(numbers[i] - right) == 3)
							xR = 1;
						else if (Math.abs(numbers[i] - right) == 3)
							xR = 1;
						else if (Math.abs(numbers[i] - right) == 5)
							xR = 2;
					} else if (right == 8) {
						if (Math.abs(numbers[i] - right) == 6)
							xR = 2;
						else if (Math.abs(numbers[i] - right) == 3)
							xR = 1;
						else if (Math.abs(numbers[i] - right) == 8)
							xR = 1;
					} else if (right == 0) {
						if (Math.abs(numbers[i] - right) == 2)
							xR = 3;
						else if (Math.abs(numbers[i] - right) == 5)
							xR = 2;
						else if (Math.abs(numbers[i] - right) == 8)
							xR = 1;
					}
					// ============끝나면
					if (xL < xR) {
						left = numbers[i];
						answer += "L";
					} else if (xL > xR) {
						right = numbers[i];
						answer += "R";
					} else {
						if (hand == "right") {
							right = numbers[i];
							answer += "R";
						} else {
							left = numbers[i];
							answer += "L";
						}
					}
				}
			} // 2,5,8,0 end of if
			System.out.println(answer);
		} // end of for
		return answer;
	}// end of method
}// end of class
