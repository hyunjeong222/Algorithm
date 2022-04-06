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
	}

}
