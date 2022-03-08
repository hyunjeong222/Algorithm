package programmers;

// 2020 KAKAO BLIND RECRUITMENT > 문자열 압축
// 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return
public class Solution_08 {
	public static void main(String[] args) {
		String s = "abcabcdede"; // 압축할 문자열
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
        int answer = s.length(); // 압축 전 문자열의 길이로 초기화
        for (int i = 1; i <= s.length() / 2; i++) {
			int level = 1; // 현재 압축 정도
			String str = s.substring(0,i); // 압축 할 문자
			StringBuilder result = new StringBuilder(); // 압축 완료할 문자를 저장 할 StringBuilder
			
			for (int j = i; j <= s.length(); j+=i) {
				String next = s.substring(j, i+j > s.length() ? s.length() : i+j); // 다음 문자
				if (str.equals(next)) { // 현재 문자랑 다음 문자가 같다면
					level++; // 압축 정도 증가
				} else { // 같지 않다면
					result.append((level != 1 ? level : "") + str); // 압축 정도가 1이 아니면 압축정도 + 압축 할 문자, 1이면 "" + 압축 할 문자
					str = next; // 압축 할 문자를 다음 문자로 변경
					level = 1; // 압축 정도 1로 초기화
				}
			}
			result.append(str);
			answer = Math.min(answer, result.length());
		}
        return answer;
    }
}
