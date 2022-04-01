package programmers;

import java.util.Arrays;

// 2021 Dev-Matching: 웹 백엔드 개발자(상반기) > 행렬 테두리 회전하기
// 각 회전들을 배열에 적용한 뒤, 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return
public class Solution_20 {
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}
	static int[][] matrix; // 행렬
	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];  // 정답 배열
		matrix = new int[rows][columns]; // 행렬 생성
		int num = 1;
		for (int i = 0; i < rows; i++) {  // 행렬 초기화
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = num++;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			answer[i] = rotate(queries[i]); // 회전
		}
		return answer;
	}

	private static int rotate(int[] query) {
		int r1 = query[0]-1;
		int c1 = query[1]-1;
		int r2 = query[2]-1;
		int c2 = query[3]-1;

		int temp = matrix[r1][c1]; // 시작위치 값 임시 저장
		int min = temp; // 최솟값
		// 왼쪽 아래 -> 위
		for (int i = r1; i < r2; i++) {
			matrix[i][c1] = matrix[i+1][c1];
			if (min > matrix[i][c1]) min = matrix[i][c1];
		}
		// 아래쪽 오른 -> 왼
		for (int i = c1; i < c2; i++) {
			matrix[r2][i] = matrix[r2][i+1];
			if (min > matrix[r2][i]) min = matrix[r2][i];
		}
		// 오른쪽 위 -> 아래
		for (int i = r2; i > r1; i--) {
			matrix[i][c2] = matrix[i-1][c2];
			if (min > matrix[i][c2]) min = matrix[i][c2];
		}
		// 위쪽 왼 -> 오른
		for (int i = c2; i > c1; i--) {
			matrix[r1][i] = matrix[r1][i-1];
			if (min > matrix[r1][i]) min =matrix[r1][i];
		}
		// 마지막 값 이동
		matrix[r1][c1+1] = temp;
		return min;
	}

}
