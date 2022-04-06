package programmers;

// 연습문제 > JadenCase 문자열 만들기
// 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 return
public class Solution_02 {

	public static void main(String[] args) {
		String s = "3people unFollowed me";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		String answer = "";
		String[] arr = s.toLowerCase().split(""); // 모두 소문자
		boolean isCheck = true; // 플래그
		for (String str : arr) {
			answer += isCheck ? str.toUpperCase() : str; // 플래그가 true면 대문자 (첫 문자 대문자)
			isCheck = str.equals(" ") ? true : false; // str이 공백이면 플래그 true
		}
		return answer;
		/*
		StringBuilder answer = new StringBuilder("");
		String first = s.charAt(0) + "";
		answer.append(first.toUpperCase() + ""); // 첫 문자는 대문자
		for (int i = 1; i < s.length(); i++) { // 첫 문자 제외하고 그 다음 문자부터 탐색
			String now = s.charAt(i) + "";
			if (now.equals(" ")) answer.append(" ");
			else if (s.charAt(i - 1) == ' ') answer.append(now.toUpperCase()); // 전 문자열이 공백이면 대문자
			else answer.append(now.toLowerCase());
		}
		return answer.toString();
		*/
	}

}
