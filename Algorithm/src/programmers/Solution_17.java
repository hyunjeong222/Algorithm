package programmers;

import java.util.Stack;

// 2017 팁스타운 > 짝지어 제거하기
// 짝지어 제거하기를 성공적으로 수행할 수 있는지 return, 성공적으로 수행할 수 있으면 1을, 아닐 경우 0
public class Solution_17 {
	public static void main(String[] args) {
		String s = "cdcd";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		Stack<Character> stack = new  Stack<>();
		for (char c : s.toCharArray()) {
			if (stack.isEmpty()) stack.push(c);
			else if (c == stack.peek()) stack.pop();
			else stack.push(c);
		}
		return stack.isEmpty() ? 1 : 0;
	}

}
