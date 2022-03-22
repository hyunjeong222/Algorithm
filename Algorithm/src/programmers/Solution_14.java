package programmers;

import java.util.Stack;

// 2020 KAKAO BLIND RECRUITMENT > 괄호 변환
// "올바른 괄호 문자열"로 변환한 결과를 return
public class Solution_14 {

	public static void main(String[] args) {
		String p = "()))((()";
		System.out.println(solution(p));
	}

	public static String solution(String p) {
        // String answer = "";
        if (check(p)) return p;
        return dfs(p);
    }

	private static String dfs(String p) {
		if (p.equals("")) return p; // 이미 "올바른 괄호 문자열"이라면 그대로 return
		String u = ""; // 더 이상 분리할 수 없는 "균형잡힌 괄호 문자열"
		String v = "";
		int left = 0;
		int right = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') left++;
			else right++;
			
			if ((left != 0 && right != 0) && left == right) { // 올바른 괄호 쌍이라면	
				u = p.substring(0,i+1);
				if (i != p.length() - 1) {
					v = p.substring(i+1, p.length());
				}
				break;
			}
		}
		if (!check(u)) { // u가 올바른 괄호 쌍이 아니라면
			String temp = "(" + dfs(v);
			temp += ")";
			u = u.substring(1, u.length()-1);
			u = u.replace("(", ".");
			u = u.replace(")", "(");
			u = u.replace(".", ")");
			temp += u;
			return temp;
		} else { // 올바른 괄호라면
			return u + dfs(v);
		}
	}

	private static boolean check(String p) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) return false;
				else stack.pop();
			}
		}
		if (!stack.isEmpty()) return false;
		return true;
	}
	
}
