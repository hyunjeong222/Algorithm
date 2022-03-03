package programmers;

// top-down 방식
// Summer/Winter Coding(~2018) > 점프와 순간 이동
// 사용해야 하는 건전지 사용량의 최솟값을 return
public class Solution_03 {

	public static void main(String[] args) {
		int n = 5; // 이동하려는 거리
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int ans = 0; // 사용해야 하는 건전지 사용량의 최솟값
		while(n != 0) { // 거리가 0이 될때까지
			if(n % 2 == 0) { // 순간이동
				n /= 2;
			} else {
				n--; // 거리 감소
				ans++; // 배터리 증가
			}
		}
		return ans;
	}

}
