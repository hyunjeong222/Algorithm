package programmers;

import java.util.LinkedList;
import java.util.Queue;

// 찾아라 프로그래밍 마에스터 > 게임 맵 최단거리
// 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return
public class Solution_18 {
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}
	static int[] dx = {-1,1,0,0}; // 상하
	static int[] dy = {0,0,-1,1}; // 좌우
	// 좌표, 칸의 최솟값을 저장 할 메소드
	static class pos {
		int x;
		int y;
		int cnt;
		 public pos(int x, int y, int cnt) {
			 this.x = x;
			 this.y = y;
			 this.cnt = cnt;
		 }
	}
	static boolean[][] visited; // 방문 체크
	static int n, m; // 가로, 세로
	public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        return  bfs(0,0,maps); // 현재위치, 게임 맵
    }
	
	private static int bfs(int x, int y, int[][] maps) {
		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(x, y, 1)); // queue에 현재 위치 + 시작 칸의 개수 담기
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			pos p_q = q.poll();
			
			if (p_q.x == n - 1 && p_q.y == m - 1) return p_q.cnt; // 종료조건
			
			for (int i = 0; i < 4; i++) { // 동서남북
				// 다음좌표
				int nx = p_q.x + dx[i];
				int ny = p_q.y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) { // 범위 안에 값이 존재하고
					if (maps[nx][ny] == 1 && !visited[nx][ny]) { // 방문하지 않았고, 벽이 없는 자리라면
						visited[nx][ny] = true; // 방문 배열 체크
						q.offer(new pos(nx, ny, p_q.cnt+1)); // queue에 다음위치 + 칸 개수 증가
					}
				}
			}
		}
		return -1; // 도착할 수 없는 경우 -1 리턴
	}
	/* 풀이 2
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}
	static int[] dx = {-1,1,0,0}; // 상하
	static int[] dy = {0,0,-1,1}; // 좌우
	// 좌표를 
	static class pos {
		int x;
		int y;
		 public pos(int x, int y) {
			 this.x = x;
			 this.y = y;
		 }
	}
	static int[][] visited; // 방문 체크
	static int n, m; // 가로, 세로
	public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        bfs(0,0,maps); // 현재위치, 게임 
        int answer = visited[n-1][m-1]; // 칸의 최솟값은 맵의 마지막 값
        return answer == 0 ? -1 : answer; // answer이 0이면 도착할 수 없는 경우, 0이 아니라면 최솟값 return
    }
	
	private static int bfs(int x, int y, int[][] maps) {
		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(x, y));
		visited[x][y] = 1; // 현재위치 값 1
		
		while (!q.isEmpty()) {
			pos p_q = q.poll();
			
			if (p_q.x == n - 1 && p_q.y == m - 1) return visited[p_q.x][p_q.y]; // 종료조건
			
			for (int i = 0; i < 4; i++) {
				// 다음 좌표
				int nx = p_q.x + dx[i];
				int ny = p_q.y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
						visited[nx][ny] = visited[p_q.x][p_q.y] + 1; // 다음 좌표 값은 현재 좌표 값 + 1
						q.offer(new pos(nx, ny));
					}
				}
			}
		}
		return 0;
	}
	*/
}
