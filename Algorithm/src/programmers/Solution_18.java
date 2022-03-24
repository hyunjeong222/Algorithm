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
	static boolean[][] visited;
	static int n, m;
	public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        return  bfs(0,0,maps);
    }
	
	private static int bfs(int x, int y, int[][] maps) {
		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(x, y, 1));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			pos p_q = q.poll();
			
			if (p_q.x == n - 1 && p_q.y == m - 1) return p_q.cnt;
			
			for (int i = 0; i < 4; i++) {
				int nx = p_q.x + dx[i];
				int ny = p_q.y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (maps[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new pos(nx, ny, p_q.cnt+1));
					}
				}
			}
		}
		return -1;
	}
	/*
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}
	static int[] dx = {-1,1,0,0}; // 상하
	static int[] dy = {0,0,-1,1}; // 좌우
	static class pos {
		int x;
		int y;
		 public pos(int x, int y) {
			 this.x = x;
			 this.y = y;
		 }
	}
	static int[][] visited;
	static int n, m;
	public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        bfs(0,0,maps);
        int answer = visited[n-1][m-1];
        return answer == 0 ? -1 : answer;
    }
	
	private static int bfs(int x, int y, int[][] maps) {
		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(x, y));
		visited[x][y] = 1;
		
		while (!q.isEmpty()) {
			pos p_q = q.poll();
			
			if (p_q.x == n - 1 && p_q.y == m - 1) return visited[p_q.x][p_q.y];
			
			for (int i = 0; i < 4; i++) {
				int nx = p_q.x + dx[i];
				int ny = p_q.y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
						visited[nx][ny] = visited[p_q.x][p_q.y] + 1;
						q.offer(new pos(nx, ny));
					}
				}
			}
		}
		return 0;
	}
	*/
}
