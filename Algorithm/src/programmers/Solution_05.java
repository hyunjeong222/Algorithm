package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 2017 카카오코드 예선 > 카카오프렌즈 컬러링북
// 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 return
public class Solution_05 {
	// 좌표에서 상,하,좌,우를 탐색하기 위한 배열
	static int[] dx = {-1,1,0,0}; // 상하 (행)
	static int[] dy = {0,0,-1,1}; // 좌우 (열)
	static boolean[][] visited;
	static int[][] map;
	// 좌표를 저장하는 클래스
	static public class pos {
		int x;
		int y;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int count, N, M ; // 전역변수
	public static void main(String[] args) {
		int m = 6; // 그림의 크기
		int n = 4; // n x m
		int[][] picture = {{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}};
		System.out.println(Arrays.toString(solution(m,n,picture)));
	}

	public static int[] solution(int m, int n, int[][] picture) {
		// 전역변수 초기화
		N = n;
		M = m;
		count = 0;
		
		// 배열의 크기 정의
		map = new int[m][n];
		visited = new boolean[m][n];
		
		// 지도 입력
		for (int i = 0; i <m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = picture[i][j];
			}
		}
		// System.out.println(Arrays.deepToString(map));

		int area = 0; // 영역 개수
		int max = 0; // 가장 큰 영역
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0 && !visited[i][j]) { // 영역의 수가 0이 아니고 방문하지 않았다면
					area++; // 영역 개수 증가
					max = Math.max(max, dfs(i,j)); // 가장 큰 영역 비교
				}
			}

		}
		int[] answer = new int[2];
		answer[0] = area;
		answer[1] = max;
		return answer;
	}

	private static int dfs(int x, int y) {
		Queue<pos> queue = new LinkedList<pos>();
		queue.offer(new pos(x, y)); // 처음 입력받은 좌표를 큐에 담음
		visited[x][y] = true; // 해당 좌표 방문 표시
		count = 1; // 지나온 칸의 개수
		
		while (!queue.isEmpty()) {
			pos p_q = queue.poll(); // 전달받은 좌표
			
			for (int i = 0; i < 4; i++) { // 상하좌우 탐색
				// 각 값의 계산에 따라 상, 하, 좌, 우의 좌표가 저장되며 반복
				int nx = p_q.x + dx[i]; 
				int ny = p_q.y + dy[i];
				
				if(nx < M  && nx >= 0 && ny < N  && ny >= 0 && !visited[nx][ny]) { // 값이 범위 안에 존재한다면
					if (map[nx][ny] == map[x][y]) { // 현재 위치가 0이 아니고 같은 영역이라면
						queue.offer(new pos(nx,ny)); // 다음 영역의 좌표를 큐에 넣어준 뒤 계속해서 탐색
						visited[nx][ny] = true; // 다음 영역 방문처리
						count++; // 지나온 칸의 개수 증가
					}
				}
			}
		}
		return count;
	}

}
