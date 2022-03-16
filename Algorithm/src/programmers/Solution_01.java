package programmers;

// Summer/Winter Coding(~2018) > 소수 만들기
// nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return

public class Solution_01 {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4}; // 숫자들이 들어있는 배열
		System.out.println(solution(nums));
	}
	
	public static int solution(int[] nums) {
		int answer = 0; // 소수가 되는 경우의 개수
		int sum = 0; // 서로 다른 숫자 3개의 합
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					sum = nums[i] + nums[j] + nums[k]; // 서로 다른 3개를 골라 더하기
					
					if (isPrime(sum)) { // 만약 소수라면
						answer++; // 개수 증가
					}
				}
			}
		}
		return answer;
	}
	
	// 소수 체크 함수
	private static boolean isPrime(int sum) {
		for (int i = 2; i <= Math.sqrt(sum); i++) { // 0과 1은 소수 아님
			if (sum % i == 0) return false; // 한번이라도 나눠지면 0이 아님
		}
		return true; // 나눠지지 않으면 소수
	}
	
}
