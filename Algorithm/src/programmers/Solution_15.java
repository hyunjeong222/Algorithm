package programmers;

// 2018 KAKAO BLIND RECRUITMENT > [1차] 다트 게임
// 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수 return
public class Solution_15 {
	public static void main(String[] args) {
		String dartResult = "1S2D*3T";
		System.out.println(solution(dartResult));
	}

	public static int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3]; // 3번의 기회에서 얻은 점수를 담을 배열
        String s_num = "";
        int i_num = 0;
        int idx = 0;
        for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			
			if (c >= '0'  && c <= '9') {
				s_num += String.valueOf(c);
			} else if (c == 'S' || c == 'D' || c == 'T') {
				i_num = Integer.parseInt(s_num);
				if (c == 'S') {
					i_num = (int) Math.pow(i_num, 1); // 거듭 제곱 구하기
				} else if (c == 'D') {
					i_num = (int) Math.pow(i_num, 2);
				} else {
					i_num = (int) Math.pow(i_num, 3);
				}
				score[idx++] = i_num;
				s_num = ""; // 초기화
			} else {
				if (c == '#') {
					score[idx - 1] *= -1;
				} else {
					score[idx - 1] *= 2; //  해당 점수와 
					if (idx - 2 >= 0) { // 바로 전에 얻은 점수를
						score[idx - 2] *= 2; // 각 2배
					}
				}
			}
		}
        for (int i = 0; i < score.length; i++) {
			answer += score[i];
		}
        return answer;
    }
	
}
