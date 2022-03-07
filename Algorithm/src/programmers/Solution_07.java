package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

// 2019 KAKAO BLIND RECRUITMENT > 오픈채팅방
// 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return
public class Solution_07 {
	public static void main(String[] args) {
		// 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
	}

	public static String[] solution(String[] record) {
		String[] answer = {};
		ArrayList<String> list = new ArrayList<String>(); // 기록을 남길 리스트
		HashMap<String, String> map = new LinkedHashMap<String, String>(); // 유저 아이디, 닉네임
		for (String r : record) {
			String[] arr = r.split(" ");
			if (arr[0].equals("Enter")) {
				list.add(arr[1] + "님이 들어왔습니다.");
				map.put(arr[1], arr[2]);
			} else if (arr[0].equals("Change")) {
				map.put(arr[1], arr[2]); // 닉네임 최신화
			} else {
				list.add(arr[1] + "님이 나갔습니다.");
			}
		}
		// System.out.println(list);
		// [uid1234님이 들어왔습니다., uid4567님이 들어왔습니다., uid1234님이 나갔습니다., uid1234님이 들어왔습니다.]
		// System.out.println(map);
		answer = new String[list.size()]; // 배열 크기 정의
		for (int i = 0; i < list.size(); i++) {
			int idx = list.get(i).indexOf("님"); // 유저 아이디만 자르기 위한 위치값
			String id = list.get(i).substring(0,idx); // 유저 아이디
			// System.out.println(id);
			answer[i] = map.get(id) + list.get(i).substring(idx); // 유저 아이디를 닉네임으로 변경 + 상태
		}
		return answer;
	}
}