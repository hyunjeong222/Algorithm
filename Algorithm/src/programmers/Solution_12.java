package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 2021 카카오 채용연계형 인턴십 > 거리두기 확인하기
// 각 대기실별로 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 배열에 담아 return
public class Solution_12 {
	
	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(Arrays.toString(solution(places)));
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static public class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[] solution(String[][] places) {
        int[] answer = new int[places.length]; // 각 대기실별로 거리두기 지킴 여부
        for (int i = 0; i < places.length; i++) {
			String[] p = places[i]; // 하나의 대기실 구조
			boolean isCheck = true; // 거리두기 지킴 여부
			for (int r = 0; r < places.length; r++) {
				for (int c = 0; c < places.length; c++) {
					if (p[r].charAt(c) == 'P' && isCheck) {
						if (!bfs(r,c,p)) { // 현재좌표, 하나의 대기실 구조
							isCheck = false; // 지키지 않고 있다면 false
						}
					}
				}
			}
			answer[i] = isCheck ? 1 : 0; // 거리두기를 지키고 있으면 1을, 지키지 않고 있으면 0
		}
        return answer;
    }
	
	private static boolean bfs(int x, int y, String[] p) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(x, y)); // 현재 좌표 담기

        while (!queue.isEmpty()) {
            Pos p_q = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p_q.x + dx[i]; // 다음위치
                int ny = p_q.y + dy[i]; // 다음위치
                
                // 범위를 벗어나고 현재 위치랑 다음 위치가 같다면 무시
                if (nx < 0 || ny < 0 || nx >= p.length || ny >= p.length || (nx == x && ny == y)) continue;

                int d = Math.abs(nx - x) + Math.abs(ny - y); // 맨해튼 거리
                
                if (p[nx].charAt(ny) == 'P' && d <= 2) // 다음위치가 P고 맨해튼 거리가 2이하라면
                    return false; // 거리두기 안지켜짐
                else if (p[nx].charAt(ny) == 'O' && d < 2) // 다음위치가 O고 맨해튼 거리가 2이상이라면
                    queue.offer(new Pos(nx, ny)); // 거리두기 지켜짐, 계속 탐색
            }
        }
        return true;
	}
}
