package programmers;

import java.util.Stack;

// 2017 팁스타운 > 짝지어 제거하기
// 짝지어 제거하기를 성공적으로 수행할 수 있는지 return, 성공적으로 수행할 수 있으면 1을, 아닐 경우 0
public class Solution_17 {
	public static void main(String[] args) {
		String s = "baabaa";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		Stack<Character> stack = new  Stack<>();
		for (char c : s.toCharArray()) {
			if (stack.isEmpty()) stack.push(c); // stack이 비어있다면 문자 추가
			else if (c == stack.peek()) stack.pop(); // 문자와 stack의 첫번째 값이 같다면 짝이므로 제거
			else stack.push(c); // 모두 아니라면 stack에 추가
		}
		return stack.isEmpty() ? 1 : 0; // stack이 비어있다면 짝지어 제거하기 성공 1리턴, 아니라면 0리턴
	}

}
