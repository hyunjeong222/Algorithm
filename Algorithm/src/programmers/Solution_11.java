package programmers;

// 월간 코드 챌린지 시즌1 > 내적
// a와 b의 내적을 return
public class Solution_11 {
	
	public static void main(String[] args) {
		int[] a = {-1,0,1};
		int[] b = {1,0,-1};
		System.out.println(solution(a,b));
	}
	
	public static int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
        	// a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)
        	answer += a[i] * b[i];
		}
        return answer;
    }

}
