package programmers;

// 동적계획법(Dynamic Programming) > N으로 표현
// N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return
// 최솟값이 8보다 크면 -1을 return
// dfs
public class Solution_10 {
	public static void main(String[] args) {
		int N = 5; // 사용할 수
		int number = 12; // 만들어야 하는 수
		System.out.println(solution(N,number));
	}
	static int answer;
	public static int solution(int N, int number) {
		answer = -1; // N 사용횟수의 최솟값, -1로 변경
		dfs(N,number,0,0);
		return answer;
	}
	
	// 사용할 수, 만들어야 하는 수, 사용한 횟수, 만든 수
	private static void dfs(int N, int number, int count, int sum) {
		if (count > 8) return; // 사용한 횟수가 8보다 크다면 return

		if (number == sum) { // 만들어야 하는 수와 만든 수가 같다면
			if (answer == -1) answer  = count; // 사용 횟수가 -1이라면 사용횟수 갱신
			else answer = Math.min(answer, count); // 아니라면 횟수 비교하여 최소값 추출
			return;
		}
		
		int nn = 0;
		for (int i = 1; i <= 8-count; i++) {
			nn = (nn * 10) + N; // n, nn, nnn, ... 을 만들어주기
			// 사칙연산
			dfs(N,number,i+count,sum+nn);
			dfs(N,number,i+count,sum-nn);
			dfs(N,number,i+count,sum*nn);
			dfs(N,number,i+count,sum/nn);
		}
	}
}

/*
public class Solution_10 { // dp
	public static void main(String[] args) {
		int N = 5; // 사용할 수
		int number = 12; // 만들어야 하는 수
		System.out.println(solution(N,number));
	}
	
	public static int solution(int N, int number) {
		int answer = 0;
		return answer;
	}
	
}
*/