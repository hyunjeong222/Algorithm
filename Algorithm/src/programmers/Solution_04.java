package programmers;

// top-down 방식
// Summer/Winter Coding(~2018) > 점프와 순간 이동
// 사용해야 하는 건전지 사용량의 최솟값을 return
public class Solution_04 {
	
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}; // 순서대로 누를 번호가 담긴 배열
		String hand = "right"; // 왼손잡이인지 오른손잡이인 지를 나타내는 문자열
		System.out.println(solution(numbers,hand));
	}
	static int[][] board = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,1},{3,2}}; // 키패드 좌표값
	public static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder("");
		int left_pos = 10; // *
		int right_pos = 12; // #
		
		for (int n : numbers) {
			if (n == 1 || n == 4 || n == 7) { // 왼손
				answer.append("L" + "");
				left_pos = n; // 현재 위치 변경
			} else if (n == 3 || n == 6 || n == 9) { // 오른손
				answer.append("R" + "");
				right_pos = n; // 현재 위치 변경
			} else { // 2, 5, 8, 0이라면
				// 0을 11로 치환
				if (n == 0) n = 11;
				// 현재 위치에서 더 가까운, 거리가 같다면 왼손잡이, 오른손잡이 유무로 판별
				int left_distance = distance(left_pos,n); // 현재 위치, 가야 할 위치
				int right_distance = distance(right_pos,n); // 현재 위치, 가야 할 위치
				
				if (left_distance > right_distance) { // 값이 크다면 더 멈
					answer.append("R" + "");
					right_pos = n ;
				} else if (left_distance < right_distance) {
					answer.append("L" + "");
					left_pos = n ;
				} else { // 값이 같다면
					if (hand.equals("right")) { // 오른손잡이라면
						answer.append("R" + "");
						right_pos = n ;
					} else { // hand.equals("left"), 왼손잡이라면
						answer.append("L" + "");
						left_pos = n ;
					}
				}
			}
		}
		return answer.toString();
	}
	
	// 거리 체크
	private static int distance(int pos, int n) {
		int left_distance = Math.abs(board[pos-1][0] - board[n-1][0]);
		int right_distance = Math.abs(board[pos-1][1] - board[n-1][1]);
		return (left_distance + right_distance);
	}

}
