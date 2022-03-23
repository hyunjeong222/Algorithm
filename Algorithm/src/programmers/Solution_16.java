package programmers;

import java.util.Stack;

// 월간 코드 챌린지 시즌2 > 괄호 회전하기
// s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return
public class Solution_16 {
	public static void main(String[] args) {
		String s = "[](){}";
		System.out.println(solution(s));
	}
    
	public static int solution(String s) {
        int answer = 0; // x의 개수
        String new_s = s; // 새롭게 만들 문자열, 시작은 s
        for (int i = 0; i < s.length(); i++) {
			if (check(new_s)) answer++; // 올바른 문자열이라면 x개수 증가
			new_s = new_s.substring(1, s.length()) + new_s.charAt(0); // 괄호를 회전한 모습
		}
        return answer;
    	}

	// 올바른 괄호 체크 메소드
	private static boolean check(String s) {
		Stack<Character> stack = new Stack<>(); // 올바른 괄호 판별을 위해 stack 선언
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) { // stack이 비어있으면 일단 괄호 추가
				stack.push(c);
			} else if (c == ')' && stack.peek() == '(') { // 괄호 쌍이라면
				stack.pop(); // stack에서 제거
            		} else if (c == '}' && stack.peek() == '{') {
            			stack.pop();
            		} else if (c == ']' && stack.peek() == '[') {
            			stack.pop();
            		} else { // 아니라면
            			stack.push(c); // stack 추가
            		}
		}
		if (stack.isEmpty()) return true; // 올바른 문자열이면 stack이 빔
		return false;
	}
}
