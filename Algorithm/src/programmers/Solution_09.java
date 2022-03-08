package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
// 2021 KAKAO BLIND RECRUITMENT > 메뉴 리뉴얼
// "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 사전 순으로 오름차순 정렬해서 return
// 만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return
public class Solution_09 {
	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"}; // 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열
		int[] course = {2,3,4}; // "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열
		System.out.println(Arrays.toString(solution(orders,course)));
	}
	static String str; // 만들어진 조합
	static HashMap<String, Integer> menu; // 모든 메뉴의 조합, 선택 횟수
	static boolean visited[];; // 조합에 뽑혔는지를 확인할 배열
	static int max[]; // course[j]번째를 고르는 경우의 수 중, 가장 많이 선택된 횟수를 저장 할 배열

	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		ArrayList<String> list = new ArrayList<String>(); // 새로 추가하게 될 코스요리의 메뉴 구성을 담을 list

		max = new int[course.length]; // 각 메뉴에 가장 많이 선택된 횟수
		menu = new HashMap<String, Integer>(); // 모든 메뉴의 조합, 선택 횟수

		for (int i = 0; i < orders.length; i++) {
			char[] arr = orders[i].toCharArray();
			Arrays.sort(arr); // 오름차순으로 정렬
			str = String.copyValueOf(arr); // 문자열 형태로 변경
			
			for (int j = 0; j < course.length; j++) {
				visited = new boolean[str.length()];
				comb(0, 0, "", j, course[j]);
			}
		}
		for (String s : menu.keySet()) {
			for (int i = 0; i < course.length; i++) {
				if (course[i] == s.length() && max[i] != 1 && menu.get(s) == max[i]) {
					list.add(s);
				}
			}
		}		

		Collections.sort(list);
		answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	// cursor : 선택한 문자의 위치
	// cnt : 현재까지 선택된 메뉴의 개수
	// s : 현재까지 선택된 메뉴의 조합
	// j : 배열의 위치를 찾기 위한 index
	// n : 선택해야 하는 메뉴의 개수
	private static void comb(int cursor, int cnt, String s, int j, int n) {
		if (cnt == n) { // 현재까지 선택된 메뉴의 개수와 선택해야 하는 메뉴의 개수가 같다면
			menu.put(s, menu.getOrDefault(s, 0)+1); // 현재까지 선택된 메뉴의 조합, 선택 횟수
			max[j] = Math.max(max[j], menu.get(s)); // 각 개수별 최대 선택 횟수를 저장
			return;
		}

		for (int i = cursor; i < str.length(); i++) {
			visited[i] = true;
			comb(i + 1, cnt + 1, s + str.charAt(i), j, n);
		}
	}
}
