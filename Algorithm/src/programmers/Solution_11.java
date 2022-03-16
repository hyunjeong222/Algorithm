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
        	answer += a[i] * b[i];
		}
        return answer;
    }

}
