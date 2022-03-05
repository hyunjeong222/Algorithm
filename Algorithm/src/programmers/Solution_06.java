package programmers;

// 2021 KAKAO BLIND RECRUITMENT > 신규 아이디 추천
// "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return
public class Solution_06 {
	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm"; // 신규 유저가 입력한 아이디
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
        String answer = "";
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환
        new_id = new_id.toLowerCase();
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        for (char c : new_id.toCharArray()) {
			if ('a' <= c && 'z' >= c) { // 알파벳 소문자
				answer += String.valueOf(c);
			} else if ( '0' <= c && '9' >= c) { // 숫자
				answer += String.valueOf(c);
			} else if (c == '-' || c == '_' || c == '.') { // 빼기(-), 밑줄(_), 마침표(.)
				answer += String.valueOf(c);
			}
		}
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        for (int i = 0; i < answer.length(); i++) {
			if (answer.charAt(i) == '.') {
				int j = i + 1; // i보다 하나 앞서 탐색
				String dot = ".";
				
				while (j != answer.length() && answer.charAt(j) == '.') { // j가 문자열의 길이와 같고, j번째 문자가 마침표가 아닐 때까지 반복
					dot += '.'; // 문자열에 마침표 추가
					j++; // 다음 탐색
				}
				
				if (dot.length() > 1) { // dot의 길이가 1보다 크다면 마침표가 연속으로 존재
					answer = answer.replace(dot, "."); // 하나의 마침표로 치환
				}
			}
		}
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거
        if (answer.startsWith(".")) { // 마침표(.)가 처음에 위치
        	answer = answer.substring(1, answer.length()); // 제거
        } else if (answer.endsWith(".")) { // 마침표(.)가 끝에 위치한다면
        	answer = answer.substring(0, answer.length()-1); // 제거
        }
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입
        if (answer.length() == 0) {
        	answer += "a";
        }
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        if (answer.length() >= 16) {
        	answer = answer.substring(0, 15);
        }
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
        if (answer.endsWith(".")) {
        	answer = answer.substring(0,answer.length()-1);
        }
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
        String last = answer.charAt(answer.length()-1) + "";
        if (answer.length() <= 2) {
        	while (answer.length() < 3) {
        		answer += last;
			}
        }
        return answer;
    }
}
/*
public class Solution_06 {
	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm"; // 신규 유저가 입력한 아이디
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
		String id = new_id.toLowerCase(); // 소문자로 
		id = id.replaceAll("[^-_.a-z0-9]", ""); // -_. 영문자 숫자만 남김 
		id = id.replaceAll("[.]{2,}", "."); // .2개 이상 .으로 
		id = id.replaceAll("^[.]|[.]$", ""); // 처음과 끝 . 제거 

		if (id.equals("")) // 빈 문자열이라면 a 추가 
			id += "a";

		if (id.length() >= 16){ // 16자 이상이면 15자로 
			id = id.substring(0, 15);
			id = id.replaceAll("^[.]|[.]$", ""); // 끝 . 제거 
		}
		if (id.length() <= 2) // 2자 이하라면 3자까지 마지막 문자추가 
			while(id.length() < 3)
				id += id.charAt(id.length() - 1);
		
		return id;
	}
}
*/